<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>编写日志</title>
    
    
    <script type="text/javascript">
    	function getLogMessagePlan()
    	{
    		var logMessagePlanSelect=document.getElementById("logMessagePlan");
    		var logMessagePlanHidden=document.getElementById("logMessage.logMessagePlan");
    		logMessagePlanHidden.value=logMessagePlanSelect.value;
    	}
    </script>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  </head>
  <!-- http://localhost:8080/empLogssh2/web/logMessage/insertLogMessage.jsp -->
  <body>
  <!-- 
   	<h1>指定编写者者为4，也就是说，这个页面登入的成员的Id为4 ,发送等级为1,在提交的时候，也要向ReceiveLog表插入数据日志Id和员工id，说明这条日志发送给了谁(在保存后提交到ReceiveLog,根据empId查询6、	EmpCheckLogEmail表得到里面的checkEmpId对象)</h1>
   	
   	<s:form action="saveLogMessage" theme="simple">
   		<s:hidden name="logMessage.emp.empId" value="4"></s:hidden>	
   	
	   	标题:<s:textfield name="logMessage.logMessageTitle" label="标题" ></s:textfield><br />
	   	内容一:<s:textarea name="logMessage.logMessageContent1" label="内容一" ></s:textarea><br />
	   	内容二:<s:textarea name="logMessage.logMessageContent2" label="内容二" ></s:textarea><br />
	   	内容三:<s:textarea name="logMessage.logMessageContent3" label="内容三" ></s:textarea><br />
	   	发送等级：
	   	<select id="logMessagePlan" name="logMessagePlan" onchange="getLogMessagePlan()">
	   		<option value="1">1</option>
	   		<option value="2">2</option>
	   		<option value="3">3</option>
	   	</select><br />
	   	
	   	<s:hidden name="logMessage.logMessagePlan" value="1"></s:hidden>	
	   	
	   	备注:<s:textarea name="logMessage.logMessageRemark" label="备注" ></s:textarea><br />
	   	
	   	<s:submit id="sub" name="sub" value="提交" ></s:submit>
   	</s:form>
    -->	
<!-- end of menu wrapper -->
<div id="tempatemo_content_wrapper">
  <div id="templatemo_content">
    <div id="content_panel">
    
      <s:form action="saveLogMessage" theme="simple">
        <table class="tab" width="95%" border="0"  cellspacing="0" cellpadding="0" align="center" style=" margin-top:15px; margin-bottom:15px; line-height:30px;">
          <tr height="40">
            <td colspan="2"><p style="font-size:25px; font-weight:bold; color:#dad021"><img src="${ctx}/img/wLog.gif"/> 填写日志</p></td>
          </tr>
          <tr>
            <td>
            	<strong>标题：</strong>
            </td>
            <td>
              <s:hidden id="logMessage.emp.empId" name="logMessage.emp.empId" value="%{#session.EMP_SESSION.empId}"></s:hidden> 
             
              <s:textfield name="logMessage.logMessageTitle" label="标题" ></s:textfield>
              <span style="color:#F00"> *标题为固定格式，例如：软件部 贾秋林 工作汇报</span>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              	发送等级：
			   	<select id="logMessagePlan" name="logMessagePlan" onchange="getLogMessagePlan()">
			   		<option value="1">普通</option>
			   		<option value="2">加急</option>
			   		<option value="3">紧急</option>
			   	</select>
			   	<s:hidden name="logMessage.logMessagePlan" value="1"></s:hidden>	
			   	<br />
            </td>
          </tr>
          <tr height="145">
            <td><strong>已完成业务：</strong></td>
            <td><s:textarea name="logMessage.logMessageContent1" id="logMessage.logMessageContent1" label="已完成业务" cssClass="xheditor {width:'100%',height:'140'}"></s:textarea></td>
          </tr>
          <tr height="145">
            <td><strong>进行中业务：</strong></td>
            <td><s:textarea name="logMessage.logMessageContent2" id="logMessage.logMessageContent2" label="进行中业务" cssClass="xheditor {width:'100%',height:'140'}"></s:textarea></td>
          </tr>
          <tr height="145">
            <td><strong>备忘录：</strong></td>
            <td>
            <s:textarea name="logMessage.logMessageContent3" id="logMessage.logMessageContent3" label="备忘录" cssClass="xheditor {width:'100%',height:'140'}"></s:textarea>
            <s:hidden name="logMessage.logMessageRemark" label="备注" value="无"></s:hidden></td>
          </tr>
          <tr align="center">
            <td colspan="2">
              <s:submit id="sub" name="sub" value="提交" ></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input name="" type="reset" value="重写"/>
             </td>
          </tr>
        </table>
      </s:form>
    </div>
    <!-- end of content panel -->
    <div class="cleaner"></div>
  </div>
  <!-- end of content -->
</div>
<!-- end of content wrapper -->
   	
   	
   	
   	
  </body>
</html>
