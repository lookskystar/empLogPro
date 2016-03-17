<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>博克日志系统-主页顶部菜单(rightTop)-v1.0</title>

		<!--jquery-->
		<script src="${ctx}/css/jquery-1.6.min.js" type="text/javascript"></script>
		<script src="${ctx}/css/kwicks/js/jquery.easing.1.3.js"
			type="text/javascript"></script>
		<script src="${ctx}/css/kwicks/js/jquery.kwicks-1.5.1.pack.js"
			type="text/javascript"></script>
		<link rel="stylesheet" type="text/css"
			href="${ctx}/css/kwicks/css/main.css" />

  </head>
  
  <body>
    <div id="rightTopDiv" class="rightTopDivClass" style="background:url('/empLogssh2/img/top.gif') no-repeat right top; height:50px;">
						<div class="kwicks_container">
							<ul class="kwicks">
								<li id="kwick_1">
									<img src="${ctx}/img/01.gif">&nbsp;<a href="#">我的信息 </a>
								</li>
								<li id="kwick_2">
									<img src="${ctx}/img/02.gif">&nbsp;<a href="#">更改密码 </a>
								</li>
								<li id="kwick_3">
									<img src="${ctx}/img/03.gif">&nbsp;<a href="${ctx}/web/login/login.jsp">重新登陆 </a>
								</li>
								<li id="kwick_4">
									<img src="${ctx}/img/04.gif">&nbsp;<a href="#">安全退出 </a>
								</li>
								<li id="kwick_5">
									<img src="${ctx}/img/05.gif">&nbsp;<a href="#">帮助 </a>
								</li>
							</ul>
						</div>
		</div>
					
  </body>
</html>
