<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>显示dep</title>


<SCRIPT type="text/javascript">
	function del()
	{
	   invoke();
		if(confirm("您确定删除？"))
		{
			
			return true;
		}
		return false;
	}
	
	
</SCRIPT>

</head>
<body>
	<h1><font color="red">显示部门列表</font></h1><br/>
	
	<table border="1" width="80%" align="center">
		<tr>
			<td>序号</td>
			<td>部门名称</td>
			<td>部门备注</td>
			<td>删除</td>
			<td>更新</td>
		</tr>

		<s:iterator value="#request.list" id="dep">
			<tr>
				<td><s:property value="#dep.depId"/></td>
				<td><s:property value="#dep.depName"/></td>
				<td><s:property value="#dep.depRemark"/></td>
				<!-- %指定好，#在页面获得的id -->
				<td><s:a href="removeDep.action?dep.depId=%{#dep.depId}" onclick="return del();">删除</s:a></td> 
				<td><s:a href="findDepByDepId.action?dep.depId=%{#dep.depId}">修改</s:a></td>
			</tr>
		</s:iterator>
		
		
	</table>
	
</body>
</html>