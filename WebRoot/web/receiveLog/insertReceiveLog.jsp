<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>测试插入页面ReceiveLog表 </title>
    


  </head>
  
  <body>
    	<h1>指定日志Id为1</h1>
   	
   	<s:form action="saveReceiveLog" theme="simple">
	   	logMessageId日志Id:<s:textfield name="receiveLog.logMessage.logMessageId" label="logMessageId日志Id" ></s:textfield><br />
	   	reveiveLogEmpId接收人员:<s:textarea name="receiveLog.emp.empId" label="reveiveLogEmpId接收人员" ></s:textarea><br />
	   	<s:submit id="sub" name="sub" value="提交" ></s:submit>
   	</s:form>
  </body>
</html>
