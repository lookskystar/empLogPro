<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>

<title>保存emp</title>

<script language="javascript" type="text/javascript" src="${ctx}/util/My97DatePicker/WdatePicker.js"></script>

<!-- dwr -->
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type='text/javascript' src="${ctx}/dwr/interface/empService.js"></script> 


<script type="text/javascript">
    //DWR
	function invoke(){
		var empName=document.getElementById("emp.empName").value;
		
		if(empName==""){
			alert("请输入姓名...");
			return;
		}
	    empService.findEmpsByEmpName(empName,function(data){
		   if(data){
		   		alert("此用户名已经存在，建议重命名...");
		   }else{
		   		alert("此用户名尚未被注册！");
		   }
		});
	}
	
	//选择部门，显示部门名和给隐藏域赋部门Id
	function selectDep(){
	    var depIdSelect=document.getElementById("depSelect");
		var depIdHidden=document.getElementById("emp.dep.depId");
		var depNameTextfield=document.getElementById("depName");
		depIdHidden.value=depIdSelect.value;
		depNameTextfield.value=depIdSelect.options[depIdSelect.selectedIndex].text;
	}
	
</script>

</head>
<body>
   
<!-- http://localhost:8080/empLogssh2/saveEmpView.action -->   
<!--  
	<h1><font color="red">增加员工</font></h1><br/>
	<h2><s:property value="#request.msg" /></h2>
	
        <s:form action="saveEmp">
         	<s:select name="depSelect" list="#request.list" listKey="depId" listValue="depName" headerKey="-1" headerValue="--请选择部门--" onchange="selectDep()"></s:select>
			
			
			<s:hidden name="emp.dep.depId" label="员工部门Id"></s:hidden>
			
	    	<s:textfield name="depName" label="员工部门"  readonly="true"></s:textfield>

	    	<s:textfield name="emp.empJob" label="员工职务"></s:textfield>
	    	<s:textfield name="emp.empName" label="员工姓名"></s:textfield>
	    	
	    	<td><input type="button" id="chenckName" name="chenckName" value="验证姓名" onclick="invoke()" ></input></td>
	    	
	    	
	        
	        
	        <s:radio list="#{1:'男',0:'女'}" name="emp.empSex"></s:radio>
	        
	        
	    	<s:textfield name="emp.empBirthday" label="员工生日" onclick="WdatePicker()" cssClass="Wdate"></s:textfield>
	    	<s:textfield name="emp.empTel" label="员工电话"></s:textfield>
	    	<s:textfield name="emp.empEmail" label="员工邮件"></s:textfield>
	    	<s:textfield name="emp.empAddress" label="员工地址"></s:textfield>
	    	<s:textfield name="emp.empPassword" label="员工密码"></s:textfield>
	    	<s:textfield name="emp.empRemark" label="员工备注"></s:textfield>
	    	<s:submit value="提交"></s:submit>
   		</s:form>
  --> 		
   		
<h2><s:property value="#request.msg" /></h2>
<div style="border:1px dashed #666; padding:10px; width:100%;" align="center">
<p style="font-size:20px; font-weight:bold; color:#dad021; padding:5px; width:400px; border-bottom:2px solid #dad021">添加员工信息</p>
 <s:form action="saveEmp" theme="simple">
<table width="350px"  cellspacing="0" cellpadding="0" style="line-height:30px;">
  <tr>
    <td>&nbsp;</td>
    <td>
        <s:select name="depSelect" list="#request.list" listKey="depId" listValue="depName" headerKey="-1" headerValue="--请选择部门--" onchange="selectDep()"></s:select>
     </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工部门：</strong></td>
    <td>
    	<s:hidden name="emp.dep.depId" label="员工部门Id"></s:hidden>
	    <s:textfield name="depName" label="员工部门"  readonly="true"></s:textfield>
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工职务：</strong></td>
    <td><s:textfield name="emp.empJob" label="员工职务"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工姓名：</strong></td>
    <td><s:textfield name="emp.empName" label="员工姓名"></s:textfield></td>
    <td><input type="button" id="chenckName" name="chenckName" value="验证姓名" onclick="invoke()" ></input></td>
  </tr>
  <tr>
    <td><strong>员工性别：</strong></td>
    <td><s:radio list="#{1:'男',0:'女'}" name="emp.empSex" value="1"></s:radio></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工生日:</strong></td>
    <td><s:textfield name="emp.empBirthday" label="员工生日" onclick="WdatePicker()" cssClass="Wdate"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工电话：</strong></td>
    <td><s:textfield name="emp.empTel" label="员工电话"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工邮件：</strong></td>
    <td><s:textfield name="emp.empEmail" label="员工邮件"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工地址：</strong></td>
    <td><s:textfield name="emp.empAddress" label="员工地址"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工密码：</strong></td>
    <td><s:textfield name="emp.empPassword" label="员工密码"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><strong>员工备注：</strong></td>
    <td><s:textfield name="emp.empRemark" label="员工备注"></s:textfield></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">
      <s:submit value="提交"></s:submit>  
      <input type="reset"></input>
    </div></td>
  </tr>
</table>
</s:form>
</div>
   		

</body>
</html>