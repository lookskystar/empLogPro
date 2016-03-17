<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>显示</title>

<SCRIPT type="text/javascript">
	function del()
	{
		if(confirm("您确定删除？"))
		{
			return true;
		}
		return false;
	}
	
	//全选
	function selectAll(ob){   
    	var sel_box=document.getElementsByName(ob);   
   		for(var i=0;i<sel_box.length;i++){   
        	sel_box[i].checked=true;   
    	}   
	} 
	//反选
	function selectRverse(ob){   
    	var sel_box=document.getElementsByName(ob);   
    	for(var i=0;i<sel_box.length;i++){   
        	if(sel_box[i].checked){   
            	sel_box[i].checked=false;   
        	}   
        	else{   
            	sel_box[i].checked=true;   
        	}   
    	}   
	}  
	
	
	//选择
	function selects(ob){
		var sel_box=document.getElementsByName(ob);
		for(var i=0;i<sel_box.length;i++){   
        	if(sel_box[i].checked){
        		alert(sel_box[i].value);
        	}
    	}   
	}
	
	//批量删除
	function delSelected(ob){
		var sel_box=document.getElementsByName(ob);
		var empIds="";
		for(var i=0;i<sel_box.length;i++){   
        	if(sel_box[i].checked){
        		empIds=empIds+sel_box[i].value+',';  
        	}
    	} 
    	empIds=empIds.substring(0,empIds.length-1);
    	if(empIds==""){
    		alert("请选择");
    	}else{
    		if(confirm("您确定删除？"))
			{
			    //模拟表单提交
				document.write('<form name=empForm>');  //输出表单
				var empIdsInputText = document.createElement("input");  //创建表单元素
				
				//表单元素设置
				empIdsInputText.type="text"; 
				empIdsInputText.name="empIds"; 
				empIdsInputText.value=empIds;
                
                //得到表单和表单元素对象
				var empForm=document.forms['empForm']; 
				var empIdsText=document.getElementById['empIdsText']; 
				
				//表单设置
				empForm.appendChild(empIdsInputText);
				empForm.action='removeEmp.action'
				empForm.method='POST'; 
				empForm.submit(); 
				
				return true;
			}
			return false;
    		
    	}
	}
	
</SCRIPT>

</head>
<body>
<!-- http://localhost:8080/empLogssh2/listEmp.action -->
	<h1><font color="red">显示EMP列表</font></h1><br/>
	
	<h2><s:property value="#request.msg" /></h2>
	
	
	一共 <s:property value="#request.totalPage"/> 页，
	有<s:property value="#request.totalRow"/>条数据，
	现在是第<s:property value="#request.page"/>页
	<table border="1" width="90%" align="center">
		<tr>
			<td>序号</td>
			<td>部门Id</td>
			<td>部门名称</td>
			<td>职务</td>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>电话</td>
			<td>电子邮件</td>
			<td>地址</td>
			<td>密码</td>
			<td>备注</td>
			<td>删除</td>
			<td>修改</td>
			<td>选择</td>
		</tr>

		<s:iterator value="#request.list" id="emp">
			<tr>
				<td><s:property value="#emp.empId" default="无"/></td>
				<td><s:property value="#emp.dep.depId" default="无"/></td>
				<td><s:property value="#emp.dep.depName" default="无"/></td>
				<td><s:property value="#emp.empJob" default="无"/></td>
				<td><s:property value="#emp.empName" default="无"/></td>
				<td>
					<s:if test="1==#emp.empSex">男</s:if>
					<s:if test="0==#emp.empSex">女</s:if>
				</td>
				<td><s:property value="#emp.empBirthday" default="无"/></td>
				<td><s:property value="#emp.empTel" default="无"/></td>
				<td><s:property value="#emp.empEmail" default="无"/></td>
				<td><s:property value="#emp.empAddress" default="无"/></td>
				<td><s:property value="#emp.empPassword" default="无"/></td>
				<td><s:property value="#emp.empRemark" default="无"/></td>
				<!-- %指定好，#在页面获得的id -->
				<td><s:a href="removeEmp.action?emp.empId=%{#emp.empId}" onclick="return del();">删除</s:a></td> 
				<td><s:a href="findEmpByEmpId.action?emp.empId=%{#emp.empId}">修改</s:a></td>
		        <td><s:checkbox id="empIds" name="empIds" value="false" fieldValue="%{#emp.empId}" theme="simple"/></td>
			</tr>
		</s:iterator>
			
		
	</table>
	<input type="button" value="全选" onClick="selectAll('empIds')" />   
    <input type="button" value="反选" onClick="selectRverse('empIds')" />   
    <input type="button" value="删除选中消息" onClick="delSelected('empIds')" /> 
    
	<s:a href="saveEmpView.action">继续插入</s:a>
	
	<br>
	<br>
	<!-- 上一页，下一页 -->
	<s:a href="listEmpPaging.action?page=1">首页</s:a>--
	
	<s:a href="listEmpPaging.action?page=%{#request.page-1}">上一页</s:a>
	<br>
	<s:a href="listEmpPaging.action?page=%{#request.page+1}">下一页</s:a>
	
	--
	<s:a href="listEmpPaging.action?page=%{#request.totalPage}">最后一页</s:a>
	
	<br>

	
	
</body>
</html>