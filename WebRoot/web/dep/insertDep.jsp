<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>保存部门</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <h1><font color="red">保存页面</font></h1><br/>
    <s:form action="saveDep">
    	<s:textfield name="dep.depName" label="部门名称"></s:textfield><br/>
    	<s:textfield name="dep.depRemark" label="部门备注"></s:textfield>
    	
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
