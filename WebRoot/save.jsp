<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>保存页面</title>
</head>
<body>
    <h1><font color="red">保存页面</font></h1><br/>
    <s:form action="saveAdmin">
    	<s:textfield name="admin.adminName" label="管理员姓名"></s:textfield><br/>
    	<s:textfield name="admin.adminPassword" label="管理员密码"></s:textfield>
    	<s:textfield name="admin.adminRole" label="管理员权限"></s:textfield>
    	
    	<s:submit value="提交"></s:submit>
    </s:form>
</body>
</html>