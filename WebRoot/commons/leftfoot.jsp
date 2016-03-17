<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>博克日志系统-员工登陆信息显示(leftTop)-v1.0</title>

<style type=text/css>


.menu_title span {
	position: relative;
	top: 2px;
	left: 8px;
	color: #215DC6;
	font-weight: bold;
}



.menu_title2 span {
	position: relative;
	top: 2px;
	left: 8px;
	color: #428EFF;
	font-weight: bold;
	Cursor: hand;
}
</style>
<SCRIPT type="text/javascript" language="javascript">
function showsubmenu(sid)
{
	whichEl = eval("submenu" + sid);
	imgmenu = eval("menuTitle" + sid);
	if (whichEl.style.display == "none")
	{
		eval("submenu" + sid + ".style.display=\"\";");
		imgmenu.background="/empLogssh2/img/admin_left_up.gif";
	}
	else
	{
		eval("submenu" + sid + ".style.display=\"none\";");
		imgmenu.background="/empLogssh2/img/admin_left_down.gif";
	}
}

function loadingmenu(id){
	var loadmenu =eval("menu" + id);
	if (loadmenu.innerText=="Loading..."){
		document.frames["hiddenframe"].location.replace("LeftTree.asp?menu=menu&id="+id+"");
	}
}


//控制iframe显示页面
function getPageUrlInIframe(url)
{
	var contentIframe=document.getElementById("contentIframe");
	contentIframe.src=url;
}
</SCRIPT>

	</head>

	<body>
		<table cellpadding="0" cellspacing="0" width="140" align="center">
			<tr>
				<td height="25" class="menu_title"  background="${ctx}/img/admin_left_down.gif" id=menuTitle100
					onClick="showsubmenu(100)">
					<span>日志管理</span>
				</td>
			</tr>
			<tr>
				<td style="display: none" id='submenu100'>
					<div class=sec_menu style="width: 140">
						<table cellpadding=0 cellspacing=0 align=center width=150>
							<TBODY>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx}/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/web/logMessage/insertLogMessage.jsp');" target="_self">填写日志</a>
									</td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/listLogMessageByLogMessageEmpIdPaging.action?page=1&logMessage.emp.empId=${EMP_SESSION.empId}');" target="_self">日志列表</a>
									</td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx}/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/assignEmpEmail.action?logMessage.emp.empId=${EMP_SESSION.empId}');" target="_self">设置收件人</a>
									</td>
								</tr>
							</TBODY>
						</table>
					</div>
					<div style="width: 140">
						<table cellpadding="0" cellspacing="0" align=center width="135">
							<tr>
								<td height="20"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		
		<table cellpadding="0" cellspacing="0" width="140" align="center">
			<tr>
				<td height="25" class="menu_title"  background="${ctx}/img/admin_left_down.gif" id=menuTitle200
					onClick="showsubmenu(200)">
					<span>我的设置</span>
				</td>
			</tr>
			<tr>
				<td style="display: none" id='submenu200'>
					<div class=sec_menu style="width: 140">
						<table cellpadding=0 cellspacing=0 align=center width=150>
							<TBODY>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/findEmpByEmpId.action?emp.empId=${EMP_SESSION.empId}');" target="_self">修改资料</a>
									</td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="admin_RegUserCount.asp" target=main>更改密码</a>
									</td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="admin_RegUserCount.asp" target=main>通讯录</a>
									</td>
								</tr>
							</TBODY>
						</table>
					</div>
					<div style="width: 140">
						<table cellpadding="0" cellspacing="0" align=center width="135">
							<tr>
								<td height="20"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		
		
		
		<table cellpadding="0" cellspacing="0" width="140" align="center">
			<tr>
				<td height="25" class="menu_title"  background="${ctx}/img/admin_left_down.gif" id=menuTitle300
					onClick="showsubmenu(300)">
					<span>管理员设置</span>
				</td>
			</tr>
			<tr>
				<td style="display: none" id='submenu300'>
					<div class=sec_menu style="width: 140">
						<table cellpadding=0 cellspacing=0 align=center width=150>
							<TBODY>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/saveEmpView.action');" target="_self">添加用户</a>
									</td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="admin_RegUserCount.asp" target=main>修改用户</a>
									</td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="admin_RegUserCount.asp" target=main>添加管理员</a>
									</td>
								</tr>
							</TBODY>
						</table>
					</div>
					<div style="width: 140">
						<table cellpadding="0" cellspacing="0" align=center width="135">
							<tr>
								<td height="20"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		
		
		<table cellpadding="0" cellspacing="0" width="140" align="center">
			<tr>
				<td height="25" class="menu_title"  background="${ctx}/img/admin_left_down.gif" id=menuTitle400
					onClick="showsubmenu(400)">
					<span>在线人员</span>
				</td>
			</tr>
			<tr>
				<td style="display: none" id='submenu400'>
					<div class=sec_menu style="width: 140">
						<table cellpadding=0 cellspacing=0 align=center width=150>
							<TBODY>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/chat.action');" target="_self">在线聊天</a>
									</td>
								</tr>
							</TBODY>
						</table>
					</div>
					<div style="width: 140">
						<table cellpadding="0" cellspacing="0" align=center width="135">
							<tr>
								<td height="20"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" width="140" align="center">
			<tr>
				<td height="25" class="menu_title"  background="${ctx}/img/admin_left_down.gif" id=menuTitle500
					onClick="showsubmenu(500)">
					<span>群发邮件</span>
				</td>
			</tr>
			<tr>
				<td style="display: none" id='submenu500'>
					<div class=sec_menu style="width: 140">
						<table cellpadding=0 cellspacing=0 align=center width=150>
							<TBODY>
								<tr>
									<td height="5"></td>
								</tr>
							    <tr>
									<td height="20">
										<img src="${ctx }/img/bullet.gif" border="0" width="15" height="20">
										<a href="javascript:getPageUrlInIframe('${ctx}/mailPage.action');" target="_self">群发邮件</a>
									</td>
								</tr>
							</TBODY>
						</table>
					</div>
					<div style="width: 140">
						<table cellpadding="0" cellspacing="0" align=center width="135">
							<tr>
								<td height="20"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
