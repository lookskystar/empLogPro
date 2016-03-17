<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>显示admin信息</title>
    

  </head>
  
  <body>
    <h1><font color="red">修改页面</font></h1><br/>
   
    <s:form action="updateAdmin">
        <s:hidden name="admin.adminId" value="%{admin.adminId}"></s:hidden>
        
    	<s:textfield name="admin.adminName" value="%{admin.adminName}"></s:textfield><br/>
    	<s:textfield name="admin.adminPassword" value="%{admin.adminPassword}"></s:textfield><br/>
    	<s:textfield name="admin.adminRole" value="%{admin.adminRole}"></s:textfield><br/>
    	
    	<s:submit value="提交"></s:submit>
    </s:form>
    
  </body>
</html>
