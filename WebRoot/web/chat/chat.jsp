<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在线聊天</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
	<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
	<script type="text/javascript" src="${ctx}/dwr/interface/ChatManager.js"></script>
	
	

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#big {
	width:99%;
	margin:10px auto;
	font-size:12px;
	border:1px solid #009;
	height:450px;
}
#left {
	
	float:left;
	width:20%;
	border-right:1px solid #009;
	padding-bottom:10px;
	background-color:#dff8fc;
	height:440px;
}
#list {
	margin-left:30px;
	line-height:20px;
}
#right {
	float:right;
	width:78%;
	padding:10px;
	line-height:25px;
}
#msg
{
	height:280px;
	border:1px solid #06F;
	line-height:20px;
	margin-bottom:10px;
	background-color:#edf0e3;
}
</style>

<script type="text/javascript">
//注册帐号(把自己添加到users列表中)
function register() {
	var username=document.getElementById("username").value;
	if (username == "") {
		alert("你还没有登录！");
		return;
	}
	var username=document.getElementById("username").value;
	ChatManager.updateUsersList(username,true,function(data){
		var usersessionIdNameArray=new Array();
		usersessionIdNameArray=data.split(":"); 
        var usersessionid=usersessionIdNameArray[0];
        var userName=usersessionIdNameArray[1];    
        document.getElementById("usersessionid").value=usersessionid; 
	});	
}

function showUsers() {
	var username=document.getElementById("username").value;
	ChatManager.updateUsersList(null,false,function(data){
		var usersessionIdNameArray=new Array();
		usersessionIdNameArray=data.split(":"); 
        var usersessionid=usersessionIdNameArray[0];
        var userName=usersessionIdNameArray[1];    

        document.getElementById("usersessionid").value=usersessionid; 
        //alert(usersessionid);
	});	
}


/**
 * 页面初始化
 */
function init() {

	dwr.engine.setNotifyServerOnPageUnload(true);  //销毁以前的ScriptSession
	dwr.engine.setActiveReverseAjax(true); //激活反转 重要

    //线要查询后台users，如果有该用户sessionid就不登入，直接显示在线用户列表，如果没有就登入显示列表
	var username=document.getElementById("username").value;
	//alert(username);
	ChatManager.findByName(username,function(data){
		//alert(data);
		if(!data){
			//注册
			//alert("注册");
			register();
		}else{
			//显示列表
			//alert("显示列表");
			showUsers();
		}
    });
}


/**
 * 发送消息
 */
function send() {
	var sender = dwr.util.getValue("username"); // 获得发送者名字
	var usersessionid=dwr.util.getValue("usersessionid"); 
	var receiver = dwr.util.getValue("receiversessionid"); // 获得接受者id
	var msg = dwr.util.getValue("message"); // 获得消息内容
	if(receiver==""){
		   alert("请选择聊天的对象......");
		   return;
	}else
	//自己不能和自己说话
	if(usersessionid==receiver){
		alert("请不要自言自语......");
		return;
	}else  
	if(msg==""){
		alert("请不要发送空信心.....");
		return;
	}
    //alert("receiver---->"+receiver);	
    // 发送消息	
	ChatManager.send(sender,receiver, msg,function(data){
		var receiversname=dwr.util.getValue("receiversname"); 
		var msgDiv= document.getElementById("msg");
		if(data==false){
			sysMsg(receiversname);
			return;
		}else if(data==true){
		    msgDiv.innerHTML="<span style='color:blue;font-size:14px; font-weight: 900'>"+sender+"</span>"+"--对-->"+"<span style='color:red;font-size:14px; font-weight: 900'>"+receiversname+"</span>"+" 说："+msg+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+nowTime()+"发送<br />"+msgDiv.innerHTML;
		    dwr.util.setValue("message","");
		}
	}); 	

	//滚动条到底
	//var t = document.getElementById("msg"); 
	//t.scrollTop = t.scrollHeight;
}

//返回发送的时间
function nowTime(){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	
	var timeStr="<span style='color:#bcbdc1;font-size:12px;'>"+year+"年"+month+"月"+day+"日"+" "+hour+"小时"+minute+"分钟"+second+"秒</span>";
	return timeStr;
}


//由后台ChatManager类中send方法调用
function addChatMsg(context,receiver){  
   var msgDiv= document.getElementById("msg");
   //dwr.util.setValue("receiversessionid",receiver);
   msgDiv.innerHTML=context+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+nowTime()+"收到<br />"+msgDiv.innerHTML;
}   


//为页面所有的li元素加事件
function addAllLiEvent(){
	//找到文档中所有的<li>元素 
	var li=document.getElementsByTagName("li");
	var receivers = document.getElementById("receiversessionids"); 

	for ( var i = 0; i < li.length; i++) {	
		//创建img元素     这里了会影响选择用户的取值，把img也取到姓名中去了
		//var image= document.createElement("<img />"); 
		//image.src="${ctx}/img/msg.gif";
		//li[i].appendChild(image);
		
		li[i].onclick=function(){
			var receiversname=this.innerHTML;
			dwr.util.setValue("receiversname",receiversname); 
            //显示你现在对谁说话
			document.getElementById("showReceiver").innerHTML="你在对-->"+receiversname+"  说：";
			//根据姓名找sessionId
			getUserSessionIdByName(receiversname);	
		};
		li[i].onmouseover=function(){
			this.style.backgroundColor="#fbdaa4";
		};
		li[i].onmouseout=function(){
			this.style.backgroundColor="";
		};
	}
}

//根据姓名找sessionId
function getUserSessionIdByName(name){
	ChatManager.getUserSessionIdByName(name,function(data) {
		//给隐藏域receiversessionid赋值，
		dwr.util.setValue("receiversessionid",data);
	});
}


function sysMsg(receiversname){
	document.getElementById("showReceiver").innerHTML="你选择的用户<strong style='color:red;'>"+receiversname+"</strong>已经下线.........";
}

window.onload = init;//页面加载完毕后执行初始化方法init
</script>


  </head>
  
  <body>
		<!--<input type="button" value="注册" onclick="register();" />  ${EMP_SESSION.empName}-->
		<br />
 
  <input type="hidden" id="username" name="username" value="${EMP_SESSION.empName}"/>
  <input type="hidden" id="usersessionid" name="usersessionid"/> <!-- 不变 -->
  <input type="hidden" id="receiversessionid" name="receiversessionid"/> <!-- 每选择一次用户就变一次 -->
  
  <input type="hidden" id="receiversname" name="receiversname"/> 
  
 <div id="big">
  <div id="left">
    <!--  <div style="font-size:16px; margin-left:10px; margin-top:10px; font-weight:bold; color:#006">技术部</div>-->
    
    <div id="list">
      <!--  <span><img src="${ctx}/img/tux.gif" width="15" height="15" align="absmiddle"/> 贾秋琳</span><br />-->
                      <strong style="color: red;">请选择聊天人员：</strong><br />
     	<!--<select name="receiver" id="receiver"></select>-->
     	<ol id="users" style="font-weight: 900;" >	
     		
     	</ol>
    </div>
  </div>
  <div id="right">
  <strong id="showReceiver"></strong>
    <div id="msg" style="overflow-y:auto; overflow-x:hidden;">  </div>
	    <div>
		    <textarea id="message" name="message" cols="80%" rows="5%"></textarea> 
		    <input id="send" name="send" type="button" value="发   送" onclick="send();"/>
	    </div>
  </div>
  </body>
</html>
