<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <!-- index.jsp改为nvigation.jsp -->
    
    <title>操作列表</title>
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
       <h1><font color="red">操作列表</font></h1><br/>
       <s:a href="/web/admin/saveAdmin.jsp">保存管理员</s:a><br/><br/><br/><br/>
       <s:a href="listAdmin.action">显示管理员列表</s:a>
  </body>
</html>
