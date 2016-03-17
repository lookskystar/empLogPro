<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>博克日志系统-员工登录-v1.0</title>
    
<STYLE type=text/css>
	BODY 
	{
		MARGIN: 90px auto;
		color:#FFF;
		font-size:12px;
	}
</STYLE>
<script language="JavaScript">
$(document).ready(function(){
	$("#adminBtn").click(function(){
		$("#empDiv").hide(2000);
		$("#adminDiv").show(2000);
	});

	$("#empBtn").click(function(){
		$("#adminDiv").hide(2000);
		$("#empDiv").show(2000);
	});
});
</script>

  </head>
  
  <body>
   <center>
  
   
  <div id="empDiv" style="background:url(/empLogssh2/img/login.jpg); width:814px; height:443px; line-height:40px;">    
   <a>用户登入</a>
    <s:form action="findEmpByEmpNameAndEmpPassword" method="post" cssStyle="padding-top:220px;" theme="simple">
    	<SPAN><strong>用户名:</strong></SPAN> <s:textfield id="emp.empName" name="emp.empName" ></s:textfield> &nbsp;&nbsp;
    	<SPAN><strong>密&nbsp;&nbsp;码:</strong></SPAN>  <s:password id="emp.empPassword" name="emp.empPassword" ></s:password>
    	<br /> <br /> 
    	<s:submit value="登 陆" id="subbut" name="subbut"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" name="resbut_emp" id="resbut" value="重 置">
    </s:form>
    <br>
    
  </div>

  <div id="adminDiv" style="background:url(/empLogssh2/img/login.jpg); width:814px; height:443px; line-height:40px; display:none;">    
   <a>管理员登入</a>
    <s:form action="findAdminByAdminNameAndAdminPassword" method="post" cssStyle="padding-top:220px;" theme="simple">
    	<SPAN><strong>管理员名:</strong></SPAN> <s:textfield id="admin.adminName" name="admin.adminName" ></s:textfield> &nbsp;&nbsp;
    	<SPAN><strong>密&nbsp;&nbsp;码:</strong></SPAN>  <s:password id="admin.adminPassword" name="admin.adminPassword" ></s:password>
    	<br /> <br /> 
    	<s:submit value="登 陆" id="subbut" name="subbut"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" name="resbut_admin" id="resbut" value="重 置">
    </s:form>
    <br>
    
  </div>
  <br>
   <span id="adminBtn" style="color:black;">管理员登入</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="empBtn" style="color:black;">用户登入</span>
</center>
  </body>
</html>
