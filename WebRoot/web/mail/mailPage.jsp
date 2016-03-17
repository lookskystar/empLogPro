<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>群发邮件</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- 进行DWR反转 -->
	<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
	<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
	<script type="text/javascript" src="${ctx}/dwr/interface/getServiceInfo.js"></script>
	
	
<style>
#big
{
	width:100%;
	border:1px solid #000000;
	font-size:12px;
	padding:10px;
	margin:10px auto;
	line-height:30px;
	background-color:#f5fdfe;
}
#accessory
{
	
	height:10px;
	border:1px solid #666;
}
#showmsg
{
	margin-top:10px;
	height:50px;
	color:#3F3;
	background-color:#333;
	padding:10px;
	OVERFLOW-y:auto;
}

#bottom
{
	padding:10px;
	margin-top:10px;
	
	background-color:#CFF;
}
</style>


<script type="text/javascript">

//上传文件插件配置
$(document).ready(function() {
	$('#uploadBtn').click(function(){    
		      dialog = new Ext.ux.UploadDialog.Dialog({    
		             title: '上传文件',    
		             url:'mailUpload.action' , //这里我用struts2做后台处理   
		             post_var_name:'file',//这里是自己定义的，默认的名字叫file,后台得得到File值
		             width : 450,    
		             height : 300,    
		             minWidth : 450,    
		             minHeight : 300,    
		             draggable : true ,    
		             resizable : true ,    
		             autoCreate: true,       
		             constraintoviewport: true ,    
		             permitted_extensions:[ 'JPG' , 'jpg' , 'jpeg' , 'JPEG' , 'GIF' , 'gif' , 'png' , 'PNG' ,'txt' , 'TXT' , 'html', 'HTML'],       
		             modal: true ,    
		             reset_on_hide: false ,    
		             allow_close_on_upload: false ,    //关闭上传窗口是否仍然上传文件    
		             //upload_autostart: true     //是否自动上传文件    
		             upload_autostart: false
		       });    
		               
		       dialog.show(); //'show-button'    
		       dialog.on( 'uploadsuccess' , onUploadSuccess); //定义上传成功回调函数   
		       dialog.on( 'uploadfailed' , onUploadFailed); //定义上传失败回调函数   
		       dialog.on( 'uploaderror' , onUploadError); //定义上传出错回调函数   
		       dialog.on( 'uploadcomplete' , onUploadComplete); //定义上传完成回调函数   
		    });   
		      
		    //文件上传成功后的回调函数   
		    onUploadSuccess = function(dialog, filename, resp_data, record){ 
			    //alert("文件上传成功后的回调函数  ");  
		        //alert(filename+"文件上传成功["+resp_data.data+"]");//resp_data是json格式的数据   
		    	//alert(filename+"文件上传成功");
		    }  ; 
		       
		    //文件上传失败后的回调函数   
		    onUploadFailed = function(dialog, filename, resp_data, record){   
		    	 //alert("文件上传失败后的回调函数   ");   
		       //alert(filename+"文件上传失败["+resp_data.data+"]");   
		       alert(filename+"文件上传失败"); 
		       return;
		    }   ;

		  //文件上传出错后的回调函数   
		    onUploadError = function(dialog, filename, resp_data, record){   
		    	//alert("文件上传出错后的回调函数   "); 
		    	 //alert(filename+"文件上传出错["+resp_data.data+"]");   
		    	 alert(filename+"文件上传出错");   
		    	 return;
		    }   ;
		       
		    //文件上传完成后的回调函数   
		    onUploadComplete = function(dialog){   
		    alert('操作完成！');
		    //alert(dialog);   
		    //dialog.hide();   
		     } ; 
});

//dwr反向
/**
 * 页面初始化
 */
function init() {
	//dwr.engine.setNotifyServerOnPageUnload(true);  //销毁以前的ScriptSession
	//dwr.engine.setActiveReverseAjax(true); //激活反转 重要
}



//由后台ChatManager类中send方法调用
function addMailMsg(context){  
  // alert(context);
  // var msgDiv= document.getElementById("showmsg");
   //dwr.util.setValue("receiversessionid",receiver);
  // msgDiv.innerHTML=context+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收到<br />"+msgDiv.innerHTML;
} 



//window.onload = init;//页面加载完毕后执行初始化方法init


//发送信息显示
function openShowModalDialog(){
	/*var obj = new Object();

	obj.senderaddress=$("#senderaddress").val();
	obj.sendername=$("#sendername").val();
	obj.subject=$("#subject").val();
	obj.head=$("#head").val();
	obj.floor=$("#floor").val();
	obj.content=$("#content").val();

	msg=window.showModalDialog('web/mail/childSendMailPage.jsp',obj,"dialogWidth=800px;dialogHeight=600px");	
	var msgDiv= document.getElementById("showmsg");
	msgDiv.innerHTML=msg;*/


	var msgDiv= document.getElementById("showmsg");
	msgDiv.innerHTML="发送进行时......（可离开此页面，继续其他工作）";
	
}

//发送前提示
function isSend(form)
{
	

	 var temp;
     temp=true;

     if(window.confirm("您确定发信息无误，发送......？"))
     {
         temp=true;
     }
     else
     {
         return false;
     }
     return temp;
	
}


//DWR
function invoke(){
	getServiceInfo.getSericeIp(function(data){
		document.getElementById("serviceIp").value=data;
	});
}

</script>



</head>
  
  <body>

    <div id="big">

<div id="showmsg">
  <p>状态信息</p>
  
 

  <strong style=" font-size: 14px; font-weight: bold;"><s:property value="#request.msg"/></strong>
  <strong style=" font-size: 14px; font-weight: bold;"><s:property value="#request.mailStaticMsg"/></strong>
 
</div>
<div id="bottom">
<input type="button" value="上传[emailAddress.txt],[template.html]两个文件（必填）及附件（选填）" id="uploadBtn" style="color:blue; font-weight: 900" />
<span style="color:red;">(收件人文本必须是emailAddress.txt[非空]名称格式，每行一个地址；模板必须是template.html[非空]名称格式)</span><br/>
<span style="color:red;">(附件：如有附件，请不要使用{emailAddress.txt}、{template.html}两个关键字名称命名，选填)</span><br />

<!-- <div id="accessory"></div> -->

<s:form action="mailSender" theme="simple" onsubmit="return isSend(this)">
发件地址:<s:textfield name="senderaddress" id="senderaddress" value="%{#request.mailusername}@%{#request.mailhost}"></s:textfield><span style="color:red;">(必填)</span>
&nbsp;名称:<s:textfield name="sendername" id="sendername" value=""></s:textfield>
&nbsp;&nbsp;
邮件主题:<s:textfield name="subject" id="subject" value=""></s:textfield><span style="color:red;">(必填)</span>
<br />
模板头部:<s:textfield name="head" id="head" value=""></s:textfield>
&nbsp;&nbsp;
模板底部:<s:textfield name="floor" id="floor" value=""></s:textfield>
&nbsp;&nbsp;
<span style="color:red;">服务器地址</span>:<input type="text" id="serviceIp" name="serviceIp" /> <input type="button" value="点击得到服务器地址" onclick="invoke();" /><br>
模板内容:<span style="color:red;">（模板头部、模板底部、模板内容非必填项，如需个性化邮件填写）</span>
<s:textarea name="content" id="content" label="邮件模板内容" cssClass="xheditor {width:'98%',height:'150'}"></s:textarea>
<!-- onclick="openShowModalDialog();" -->
<div align="right"><input name="btn" type="submit" value="发                         送"  style="color:blue; font-weight: 900"  onclick="openShowModalDialog();"/></div>
</s:form>

</div>
</div>
</body>
</html>
