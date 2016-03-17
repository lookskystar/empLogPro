<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>博克日志系统-主页-v1.0</title>

		<script type="text/javascript">
			$().ready(function() {
				$('.kwicks').kwicks({
					max : 200,
					duration: 800,  
					easing: 'easeOutQuint'
				});
			});
		</script>

	</head>

	<body>
	<DIV id="main" class="mainClass">
	
			<div id="mainContentDiv" class="mainContentDivClass">
				<div id="leftDiv" class="leftDivClass">
					<div id="leftTopDiv" class="leftTopDivClass">
						<%@ include file="../commons/leftTop.jsp"%>
					</div>
					<div id="leftfootDiv" class="leftfootDivClass">
						<%@ include file="../commons/leftfoot.jsp"%>
					</div>
				</div>

				<div id="rightDiv" class="rightDivClass">
					<%@ include file="../commons/rightTop.jsp"%>
					<iframe id="contentIframe" name="contentIframe" class="contentIframeClass" scrolling="auto" src="${ctx}/web/logMessage/insertLogMessage.jsp" width="99%" height="85%"></iframe>
				</div>
		   </div>
	    <div id="footDiv" class="footDivClass" align="center" style="font-size: 16px; font-weight: 900; background-position-y:bottom">
			<%@ include file="../commons/foot.jsp"%>
		</div>
	</DIV>	
	</body>
</html>
