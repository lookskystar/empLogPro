<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>发送窗体</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	

	
	<script language="javascript" type="text/javascript">
		function getParentFormValues(){
			 var obj = window.dialogArguments;
			 var senderaddress=obj.senderaddress;
			 var sendername=obj.sendername;
			 var subject=obj.subject;
			 var head=obj.head;
			 var floor=obj.floor;
			 var content=obj.content;
			 //alert("您传递的参数为：" + senderaddress+":"+subject+":"+head+":"+floor+":"+content);

			$("#senderaddress").val(senderaddress);
			$("#sendername").val(sendername);
			$("#subject").val(subject);
			$("#head").val(head);
			$("#floor").val(floor);
			$("#content").val(content);	

			$("#content").readonly="true";

			
		}
		function init(){
			getParentFormValues();
		}

		function closeWindow(){
			setParentMsg();

			//提交发送
			document.forms[0].submit();    

			
			window.close();                   
		}

		function setParentMsg(){
			window.returnValue="发送指令传达成功，可以关闭弹出窗体...........";
			
		}

		
		
		window.onload = init;//页面加载完毕后执行初始化方法init
	</script>

-->


  </head>
  
  <body>

<!--  <form id="formSenderMail" name="formSenderMail" action="mailSender" method="post">-->
<!--<s:form id="formSenderMail" name="formSenderMail" action="mailSender" theme="simple">
发件地址:<s:textfield name="senderaddress" id="senderaddress" value=""></s:textfield><span style="color:red;">(必填)</span>
&nbsp;名称:<s:textfield name="sendername" id="sendername" value=""></s:textfield>
&nbsp;&nbsp;
邮件主题:<s:textfield name="subject" id="subject" value=""></s:textfield><span style="color:red;">(必填)</span>
<br />
模板头部:<s:textfield name="head" id="head" value=""></s:textfield>
&nbsp;&nbsp;
模板底部:<s:textfield name="floor" id="floor" value=""></s:textfield><br />
模板内容：<span style="color:red;">（模板头部、模板底部、模板内容非必填项，如需个性化邮件填写）</span>
<s:textarea name="content" id="content" label="邮件模板内容" cssClass="xheditor {width:'98%',height:'150'}"></s:textarea>

<div align="right">

<!-- onclick="closeWindow();" 
<input name="btn" type="submit" style="color:blue; font-weight: 900"  value="发                         送"  onclick="closeWindow();"/>
<br>
点击发送按钮后，可以关闭弹出的进度条窗体！

</div>-->
<!--</s:form>-->
<!-- </form>-->



现在正在发送中............


  </body>
</html>
