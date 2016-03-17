<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改dep信息</title>
    

  </head>
  
  <body>
    <h1><font color="red">修改页面</font></h1><br/>
   
    <s:form action="updateDep">
        <s:hidden name="dep.depId" value="%{dep.depId}"></s:hidden>
        
    	<s:textfield name="dep.depName" value="%{dep.depName}"></s:textfield><br/>
    	<s:textfield name="dep.depRemark" value="%{dep.depRemark}"></s:textfield><br/>
    	<s:submit value="提交"></s:submit>
    </s:form>
    
  </body>
</html>
