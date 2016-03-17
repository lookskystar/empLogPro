<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>显示指定日志内容</title>
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!--  
      <h1>日志发送人</h1>
      发送人：${requestObj.emp.empName}
	<br />
    <h1>日志信息</h1>
	日志标题：${requestObj.logMessageTitle} <br />
	日志内容1：${requestObj.logMessageContent1} <br />
	日志内容2：${requestObj.logMessageContent2} <br />
	日志内容3：${requestObj.logMessageContent3} <br />
	日志时间：${requestObj.logMessageTime}<br />
	日志等级：${requestObj.logMessagePlan}<br />
	
	<h1>日志收件人</h1>	
		<s:iterator value="#request.list" id="receiveLog">
			<s:property value="#receiveLog.emp.empName" default="无"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</s:iterator>
		-->
		
<div id="tempatemo_content_wrapper">
  <div id="templatemo_content">
    <div id="content_panel">
        <table width="90%" border="0"  cellspacing="0" cellpadding="0" align="center" style=" margin-top:15px; margin-bottom:15px; line-height:30px;">
          <tr height="30px">
            <td colspan="2"><p style="font-size:20px; font-weight:bold; color:#dad021"><img src="${ctx}/img/conTLog.gif"/> 日志内容</p></td>
          </tr>
          <tr  height="20px">
            <td style="width: 150px;"><strong class="logContTileStrongClass">日期：</strong></td>
            <td style="color: red; font-weight: bold; font-size: 14px;">${requestObj.logMessageTime}<br /></td>
            
          </tr>
          <tr height="20px" >
            <td><strong class="logContTileStrongClass">标题：</strong></td>
            <td style="color: blue; font-weight: bold; font-size: 14px;">${requestObj.logMessageTitle}</td>
          </tr>
          
           <tr height="20px" >
            <td><strong class="logContTileStrongClass">收件人：</strong></td>
            <td style="color: gray; font-weight: bold; font-size: 12px; border-bottom: 2px red solid;">
            	<s:iterator value="#request.list" id="receiveLog">
					<s:property value="#receiveLog.emp.empName" default="无"/>&nbsp;<strong style="color: red;">|</strong>
				</s:iterator>
            </td>
          </tr>
          
           <tr align="right">
            <td colspan="2">
            <!--  <a href="#" style="color:#00F">上一篇</a> &nbsp;&nbsp;&nbsp;<a href="#" style="color:#00f">下一篇</a>&nbsp;&nbsp;&nbsp; -->
            <a href="javascript:history.go(-1);" style="color:green;">返回日志列表</a>
            <br />
            <br /></td>
          </tr>
          
          
          <tr >
            <td><img alt="完成" src="${ctx}/img/04.gif" />&nbsp;<strong class="logContTileStrongClass">已完成业务：</strong></td>
            <td>
            	<div id="logMessageContent1Div" class="logMessageDivClass">
            		${requestObj.logMessageContent1}
            	</div>
            	<br />
            </td>
          </tr>
          <tr align="right">
            <td colspan="2">
            <!--  <a href="#" style="color:#00F">上一篇</a> &nbsp;&nbsp;&nbsp;<a href="#" style="color:#00f">下一篇</a>&nbsp;&nbsp;&nbsp; -->
            <a href="javascript:history.go(-1);" style="color:green;">返回日志列表</a>
            <br />
            <br /></td>
          </tr>
          <tr >
            <td><img alt="紧急" src="${ctx}/img/01.gif" />&nbsp;<strong class="logContTileStrongClass">进行中业务：</strong></td>
            <td>
            	<div id="logMessageContent2Div" class="logMessageDivClass">
            		${requestObj.logMessageContent2}
            	</div>
            	<br />
            </td>
          </tr>
          <tr align="right">
            <td colspan="2">
            <!--  <a href="#" style="color:#00F">上一篇</a> &nbsp;&nbsp;&nbsp;<a href="#" style="color:#00f">下一篇</a>&nbsp;&nbsp;&nbsp; -->
            <a href="javascript:history.go(-1);" style="color:green;">返回日志列表</a>
            <br />
            <br /></td>
          </tr>
          <tr >
            <td><img alt="普通" src="${ctx}/img/03.gif" />&nbsp;<strong class="logContTileStrongClass">备忘录：</strong></td>
            <td>
            	<div id="logMessageContent3Div" class="logMessageDivClass">
            		${requestObj.logMessageContent3}
            	</div>
            	<br />
            </td>
          </tr>
          <tr align="right">
            <td colspan="2">
            <!--  <a href="#" style="color:#00F">上一篇</a> &nbsp;&nbsp;&nbsp;<a href="#" style="color:#00f">下一篇</a>&nbsp;&nbsp;&nbsp; --> 
            <a href="javascript:history.go(-1);" style="color:green;">返回日志列表</a>
            <br />
            <br /></td>
          </tr>
        </table>
    </div>
		
		
		
  </body>
</html>
