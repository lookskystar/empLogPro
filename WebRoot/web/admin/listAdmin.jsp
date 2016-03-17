<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- list.jsp改为listAdmin.jsp -->
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
</SCRIPT>

</head>
<body>
	<h1><font color="red">显示admin列表</font></h1><br/>
	<table border="1" width="90%" align="center">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>权限</td>
			<td>备注</td>
			<td>删除</td>
			<td>更新</td>
		</tr>
	
		<s:iterator value="#request.list" id="ad">
			<tr>
				<td><s:property value="#ad.adminId" default="无"/></td>
				<td><s:property value="#ad.adminName" default="无"/></td>
				<td><s:property value="#ad.adminPassword" default="无"/></td>
				<td><s:property value="#ad.adminRole" default="无"/></td>
				<td><s:property value="#ad.adminRemark" default="无"/></td>
				<!-- %指定好，#在页面获得的id -->
				<td><s:a href="removeAdmin.action?admin.adminId=%{#ad.adminId}" onclick="return del();">删除</s:a></td> 
				<td><s:a href="findAdminByAdminId.action?admin.adminId=%{#ad.adminId}">修改</s:a></td>
			</tr>
		</s:iterator>
			
		
	</table>
	
</body>
</html>