<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>博克日志系统-主页菜单(leftfoot)-v1.0</title>
	</head>

	<body>
		
		<table width="140" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td valign="top">
					<table cellpadding="0" cellspacing="0" width="140" align="center">
						<tr>
							<td background="${ctx}/img/title.gif"
								style="text-align: center; line-height: 32px; color: #FFF;">
								<strong>欢迎登录</strong>
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" width="140" align="center">
						<tr>
							<td height="45" class=sec_menu>
								<table width="140" border="0" cellspacing="1" cellpadding="3">
									<tr>
										<td style="color: red">
											<script language="JavaScript"><!--
												now = new Date()
												hour = now.getHours()
												document.write("登录时间：<br>" + now.toLocaleString())
												// -->
											</script>
										</td>
									</tr>
									<tr>
										<td>
											<strong>员工姓名：</strong><strong style="color: blue;">${EMP_SESSION.empName}</strong>
										</td>
									</tr>
									<tr>
										<td>
											<strong>部门：</strong>${EMP_SESSION.dep.depName}
										</td>
									</tr>
									<tr>
										<td>
											<strong>职务：</strong>${EMP_SESSION.empJob}
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
		</table>
	</body>
</html>
