<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>显示日志</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" type="text/javascript" src="${ctx}/util/My97DatePicker/WdatePicker.js"></script>
	
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
		var logMessageEmpIdHidden=document.getElementById('logMessageEmpId');
		var logMessageEmpId=logMessageEmpIdHidden.value;
		
		var sel_box=document.getElementsByName(ob);
		var logMessageIds="";
		for(var i=0;i<sel_box.length;i++){   
        	if(sel_box[i].checked){
        		logMessageIds=logMessageIds+sel_box[i].value+',';  
        	}
    	} 
    	logMessageIds=logMessageIds.substring(0,logMessageIds.length-1);
    	if(logMessageIds==""){
    		alert("请选择");
    	}else{
    		if(confirm("您确定删除？"))
			{
			    //模拟表单提交
				document.write('<form name=logMessageForm>');  //输出表单
				var logMessageIdsInputText = document.createElement("input");  //创建表单元素
							
				//表单元素设置
				logMessageIdsInputText.type="text"; 
				logMessageIdsInputText.name="logMessageIds"; 
				logMessageIdsInputText.value=logMessageIds;
                
                //得到表单和表单元素对象
				var logMessageForm=document.forms['logMessageForm']; 
				var logMessageIdsText=document.getElementById['logMessageIdsText']; 
				
				//表单设置
				logMessageForm.appendChild(logMessageIdsInputText);
				
				logMessageForm.action='removeLogMessage.action?logMessage.emp.empId='+logMessageEmpId;
				logMessageForm.method='POST'; 
				logMessageForm.submit(); 
				
				return true;
			}
			return false;
    	}
	}
</SCRIPT>
	

  </head>
  
  <!-- http://localhost:8080/empLogssh2/listLogMessageByLogMessageEmpIdPaging.action?logMessage.emp.empId=4 -->
  <body>
  

 <!-- 
  一共 <s:property value="#request.totalPage"/> 页，
	有<s:property value="#request.totalRow"/>条数据，
	现在是第<s:property value="#request.page"/>页
  
  
   <table border="1" width="90%" align="center">
		<tr>
			<td>日志Id</td>
			<td>员工Id</td>
			<td>日志标题</td>
			<td>时间</td>
			<td>等级</td>
			<td>备注</td>
			<td>删除</td>
			<td>选择</td>
		</tr>

		<s:iterator value="#request.list" id="logMessage">
			<tr>
				<td><s:property value="#logMessage.logMessageId" default="无"/></td>
				<td><s:property value="#logMessage.emp.empId" default="无"/></td>
				<td><s:a href="findByLogMessageId.action?logMessage.logMessageId=%{#logMessage.logMessageId}"><s:property value="#logMessage.logMessageTitle" default="无"/></s:a></td>
				<td><s:property value="#logMessage.logMessageTime" default="无"/></td>
				<td><s:property value="#logMessage.logMessagePlan" default="无"/></td>
				<td><br></td>
				<!-- %指定好，#在页面获得的id 
				<td><s:a href="removeLogMessage.action?logMessage.logMessageId=%{#logMessage.logMessageId}&logMessage.emp.empId=%{#logMessage.emp.empId}" onclick="return del();">删除</s:a></td> 
		        <td><s:checkbox id="logMessageIds" name="logMessageIds" value="false" fieldValue="%{#logMessage.logMessageId}" theme="simple"/><br></td>
			</tr>
		</s:iterator>
	</table>
	
	
	
	<input type="button" value="全选" onClick="selectAll('logMessageIds')" />   
    <input type="button" value="反选" onClick="selectRverse('logMessageIds')" />   
    <input type="button" value="删除选中消息" onClick="delSelected('logMessageIds')" />
    
    
    <br>
	<br>
	以登陆Id号4为logMessage.emp.empId=4，进行测试！
	<br>
	<!-- 上一页，下一页 
	<s:a href="listLogMessageByLogMessageEmpIdPaging.action?page=1&logMessage.emp.empId=4">首页</s:a>--
	
	<s:a href="listLogMessageByLogMessageEmpIdPaging.action?page=%{#request.page-1}&logMessage.emp.empId=4">上一页</s:a>
	<br>
	<s:a href="listLogMessageByLogMessageEmpIdPaging.action?page=%{#request.page+1}&logMessage.emp.empId=4">下一页</s:a>
	
	--
	<s:a href="listLogMessageByLogMessageEmpIdPaging.action?page=%{#request.totalPage}&logMessage.emp.empId=4">最后一页</s:a>
	
	<br>
    
    --> 
   
  <div style="width: 100%; height: 20px;" align="right">
  <strong style="color: blue;">提示信息:</strong><strong style="color: red; font-size: 14px; font-weight: bold;"><s:property value="#request.msg"/></strong>
  </div> 
  
  <s:hidden id="logMessageEmpId" name="logMessageEmpId" value="#session.EMP_SESSION.empId"></s:hidden>
 <div id="tempatemo_content_wrapper">
  <div id="templatemo_content">
    <div id="content_panel">
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style="font-size:25px; font-weight:bold; color:#dad021; width:852px; text-align:left; margin-top:15px; height:35px; line-height:35px;"><img src="${ctx}/img/listLog.gif"/> 日志查询</p>
        <table width="95%" border="0"  cellspacing="1" cellpadding="0" align="center" bgcolor="#cccccc" style="margin-bottom:15px; line-height:30px; text-align:center">   
           <tr bgcolor="#FFFFFF" height="30px">
            <td colspan="6" align="left" style="border-right:0px; font-weight: bold; color: blue;">
               <div align="left" style="margin-top: 5px;">
		            &nbsp;&nbsp;搜索结果如下：
		         </div>  
	            <div align="right" style="margin-bottom: 5px;">
	            	<a href="javascript:history.go(-1);" style="color:green;">返回日志列表</a>
                </div>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF" >
            <td class="listHeaderTdClass"><div align="center"><strong >标题</strong></div></td>
            <td class="listHeaderTdClass"><div align="center"><strong >发送时间</strong></div></td>
            <td class="listHeaderTdClass"><div align="center"><strong >等级</strong></div></td>
            <td class="listHeaderTdClass"><div align="center"><strong >删除</strong></div></td>
            <td class="listHeaderTdClass"><div align="center"><strong >选择</strong></div></td>
          </tr>
          <s:iterator value="#request.list" id="logMessage">
	          <tr bgcolor="#FFFFFF">
	            <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<IMG alt="日志标题" src="${ctx}/img/title_list.gif"/>&nbsp;<s:a href="findByLogMessageId.action?logMessage.logMessageId=%{#logMessage.logMessageId}" cssClass="listValueAClass"><s:property value="#logMessage.logMessageTitle" default="无"/></s:a></td>
	            <td style="color: #e05c6f"><s:date name="#logMessage.logMessageTime" format="yyyy年MM月dd日 hh时mm分ss秒" nice="false"/></td>
	        
	            <td>
	              <s:if test="1==#logMessage.logMessagePlan">普通</s:if>
				  <s:if test="2==#logMessage.logMessagePlan"><strong style="color: blue;">加急</strong></s:if>
				  <s:if test="3==#logMessage.logMessagePlan"><strong style="color: red;">紧急</strong></s:if>	
	            </td>
	            <td><a href="showlist.html" style="color:#00F"><s:a href="removeLogMessage.action?logMessage.logMessageId=%{#logMessage.logMessageId}&logMessage.emp.empId=%{#logMessage.emp.empId}" onclick="return del();"><img src="${ctx}/img/del.gif" alt="删除"/></s:a></a></td>
	            <td><s:checkbox id="logMessageIds" name="logMessageIds" value="false" fieldValue="%{#logMessage.logMessageId}" theme="simple"/></td>
	          </tr>
          </s:iterator>
            
          <tr bgcolor="#FFFFFF" height="30px">
            <td colspan="6" align="left" style="border-right:0px;">
            	 <div align="left" style="margin-top: 5px;">
		            <a href="javascript:history.go(-1);" style="color:green;">返回日志列表</a>
		         </div>  
            
	            <div align="right" style="margin-bottom: 5px;">
		            <input type="button" value="全选" onClick="selectAll('logMessageIds')" />   
	    			<input type="button" value="反选" onClick="selectRverse('logMessageIds')" />   
	   				<input type="button" value="删除选中消息" onClick="delSelected('logMessageIds')" />
                </div>
            </td>
          </tr> 
        </table>
    </div> 
  </body>
</html>
