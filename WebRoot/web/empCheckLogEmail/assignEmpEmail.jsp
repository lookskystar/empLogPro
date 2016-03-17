<%@ page language="java"  import="java.util.*"  pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>指定谁发送的日志谁接收</title>
		
		<!-- dwr -->
		<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
		<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
		<script type='text/javascript' src="${ctx}/dwr/interface/empService.js"></script> 
		
		<script type='text/javascript' src="${ctx}/dwr/interface/empCheckLogEmailService.js"></script> 
		
		<!--Jquery  
		<script type="text/javascript" src="${ctx}/util/jquery-1.6.min.js"></script>-->
		
		<style>
			.depClass{
				
				width: 200px;
			}
		</style>

<script type="text/javascript">
			var depIdStr=''; //部门Id字符串
			var depArray=new Array() 
			
		 	//通过部门id和部门名得到部门下得员工
			function invokeDep(depId,depName)
			{
			    var depNameStr=depName;
				var depEmpSelect=document.getElementById('depEmpSelect'); //得到下拉选项对象depEmpSelect
				var empDiv=document.getElementById("empDiv");//得到显示emp的容器div对象
				
				var loadingImgObj=document.getElementById("loadingImg");
				
				var htmlBRLabel=document.createElement("label"); //创建一个label对象，用来分段<br />
		    	var depNameLabel=document.createElement("label"); //显示部门名称
		    	
		    	htmlBRLabel.setAttribute("id","htmlBRLabel");
		     	depNameLabel.setAttribute("id","depNameLabel");
				
				if(depNameStr=="--请选择部门--"){
				  return;
				}
				     
			 	htmlBRLabel.innerHTML='<br /><br />';
			 	depNameLabel.innerHTML="<span style='font-size:20px; font-weight:bold; color:#dad021; text-align:left; margin-top:5px; height:30px; line-height:30px;'>"+depNameStr+'</span><br />';
		    	
		    	depArray=depIdStr.split(',');  //字符串分组
				//循环dep部门Id数组，看传进来的部门是否在此数组内，判断是否增加该部门员工	
				for(var i=0;i<depArray.length;i++)
				{
					if(depArray[i]==depId)
					{
							return;
					}
				} 
			    empDiv.appendChild(depNameLabel);
			    loadingImgObj.style.display= "block";
				empService.findEmpsByDepId(depId,function(data){
				//循环增加此部门员工，并显示
				for(var j=0;j<data.length;j++)
			    {
					 	var elabel=document.createElement("label");
					 	var empId=data[j].empId;
					 	var empName=data[j].empName;
						var echkbox = createElement(
						    	'input',                    
						    	{                            //属性数组
						    	 	type: 'checkbox',        //元素类型
						    	 	id:'check',              //id值
						    	 	name:'check',            //name值
						    	 	value:empId,             //value值
         						 	onclick: function()      //为元素添加onclick事件
         						 	{
                        				return function() 
                        				{
                            				select();        //事件执行的方法
                        			    };
                    			 	}(empId,empId)         //不知道什么意思，没有这两个值，不能执行select（）方法
               				     }
               			);
               			
               			if(j==10)
               			{
               				//alert(j);
               				elabel.innerHTML="<span style='color:blue;'>"+empName+"<span>&nbsp;&nbsp;<br />";
               			}else{
               				elabel.innerHTML="<span style='color:blue;'>"+empName+"<span>&nbsp;&nbsp;";
               			}
               			
						
						empDiv.appendChild(echkbox);
						
						empDiv.appendChild(elabel);  
				 } 
				 
				 loadingImgObj.style.display= "none";
				 
				 //每一个部门员工显示完成就换行
				 empDiv.appendChild(htmlBRLabel);
				 
				 ////通过发送人Id得到EmpCheckLogEmail的数据
				 invokeEmpCheckLogEmail();
			  });
			 
				 //部门id加入字符串数组
				 depIdStr=depIdStr+depId+',';   // 得到1,2,3,4,字符串
			}
			
			//通过发送人Id得到EmpCheckLogEmail的数据
			function invokeEmpCheckLogEmail()
			{
				var empIdUser=document.getElementById("empIdUser").value;
				
				//dwr调用empCheckLogEmailService.findAllByEmpId
				empCheckLogEmailService.findAllByEmpId(empIdUser,function(data){
					var checkboxs = document.getElementsByName('check'); 
					var checkedEmpSubimtObj=document.getElementById('sub');
					for(var k=0;k<data.length;k++)
					{   
						//循环页面所有的checkbox
						for(var l=0; l<checkboxs.length; l++)
						{ 	
							//如果dwr查询的值=页面的checkbox的value值，就checkbox选中。
							if(data[k].empByCheckEmpId.empId==checkboxs[l].value)
							{
								checkboxs[l].checked=true;
								checkedEmpSubimtObj.disabled=false;
							}
						} 
					}
				});
			}
			
			//tagName:创建元素的类型，propArr：元素属性值数组
			function createElement(tagName, propArr) 
			{
				//创建表单元素
        		var tagInput = document.createElement(tagName);
        		//循环把传进来的元素属性数组赋给创建的元素
        		for (var prop in propArr) {
            		tagInput[prop] = propArr[prop];
        		}
        		return tagInput;
    		}
			
			//判断是否有选中的checkbox，如果有提交按钮激活，没有则不可用
			function select()
			{ 	
				var checkboxs = document.getElementsByName('check'); 
				var checkedEmpSubimtObj=document.getElementById('sub');
				var flag=0;
				for(var i=0; i<checkboxs.length; i++)
				{ 
					
					if(checkboxs[i].checked)
					{
						flag++;
					}
				} 
				
				if(flag>0)
				{
					checkedEmpSubimtObj.disabled=false;
				}
				else
				{
					checkedEmpSubimtObj.disabled=true;
				}
				
			}
			
			//得到所有选中checkbox的值，empId和empName
			function checkedEmpSubimt()
			{		
				var checkboxs = document.getElementsByName('check'); 
				var empIdArrayStr='';
				for(var i=0; i<checkboxs.length; i++)
				{ 
					if(checkboxs[i].checked)
					{
						empIdArrayStr=empIdArrayStr+checkboxs[i].value+',';
					}
				} 
				document.getElementById('empIdArrayStr').value=empIdArrayStr; //得到empId字符串隐藏域对象，保存提交的empId字符串值
				if(document.getElementById('empIdArrayStr').value.length==0)
				{
					alert('请选择！');
					return;
				}
			}
			
///////////////////////////////////////////////////////////	表格操作，全选，反选
//////////////////////////////////////////////////////////		
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
						var empCheckLogEmailIds="";
						for(var i=0;i<sel_box.length;i++){   
				        	if(sel_box[i].checked){
				        		empCheckLogEmailIds=empCheckLogEmailIds+sel_box[i].value+',';  
				        	}
				    	} 
				    	empCheckLogEmailIds=empCheckLogEmailIds.substring(0,empCheckLogEmailIds.length-1);
				    	if(empCheckLogEmailIds==""){
				    		alert("请选择");
				    	}else{
				    		if(confirm("您确定删除？"))
							{
							    //模拟表单提交
								document.write('<form name=empCheckLogEmailForm>');  //输出表单
								var empCheckLogEmailIdsInputText = document.createElement("input");  //创建表单元素
								
								//表单元素设置
								empCheckLogEmailIdsInputText.type="text"; 
								empCheckLogEmailIdsInputText.name="empCheckLogEmailIds"; 
								empCheckLogEmailIdsInputText.value=empCheckLogEmailIds;
				                
				                //得到表单和表单元素对象
								var empCheckLogEmailForm=document.forms['empCheckLogEmailForm']; 
								var empCheckLogEmailIdsText=document.getElementById['empCheckLogEmailIdsText']; 
								
								//表单设置
								empCheckLogEmailForm.appendChild(empCheckLogEmailIdsInputText);
								empCheckLogEmailForm.action='removeEmpCheckLogEmail.action'
								empCheckLogEmailForm.method='POST'; 
								empCheckLogEmailForm.submit(); 
								
								return true;
							}
							return false;
		    		
		    	}
	}
</script>
	</head>
	<body>
	<!--  
		<strong>  
			&ldquo;指定发送者为4，也就是说，这个页面登入的成员的Id为4  
		</strong>
		批量添加,r如果数据库里面有此数据，就修改
		<br>
		<!-- http://localhost:8080/empLogssh2/assignEmpEmail.action 
		  显示所有部门
		 <s:select list="#request.listDep" name="depListSelect" listKey="depId" listValue="depName" headerValue="--请选择部门--" headerKey="0" onchange="invokeDep(this.value,this.options[this.selectedIndex].text)" ></s:select><br>
		 <s:form action="saveOrUpdateEmpCheckLogEmail">
		 	 <div id="empDiv" style="border: 1px red solid; width: 800px; height: 10px;">
		 	    <s:hidden id="empIdUser" name="empIdUser" value="4"></s:hidden><!--  
		 		<s:hidden id="empIdArrayStr" name="empIdArrayStr"  value=""></s:hidden><!-- 指定接收人Id字符串隐藏域1,2,3,4,5 
		 	</div>
		 	<s:submit id="sub" name="sub" value="提交" onclick="checkedEmpSubimt()" disabled="true" ></s:submit>
		 </s:form> 
		 
		 
		 显示此发送人员指定的所有接受人员<br>
		 单个添加：
		 
		 <table border="1" width="90%" align="center">
		<tr>
			<td>序号</td>
			<td>发送人员</td>
			<td>接收人员</td>
			<td>备注</td>
			<td>删除</td>
			<td>选择</td>
		</tr>

		<s:iterator value="#request.listEmpCheckLogEmail" id="empCheckLogEmail">
			<tr>
				<td><s:property value="#empCheckLogEmail.empCheckLogEmailId" default="无"/></td>
				<td><s:property value="#empCheckLogEmail.empByEmpId.empName" default="无"/></td>
				<td><s:property value="#empCheckLogEmail.empByCheckEmpId.empName" default="无"/></td>
				<td><s:property value="#empCheckLogEmail.empCheckLogEmailRemark" default="无"/></td>
				<!-- %指定好，#在页面获得的id 
				<td><s:a href="removeEmpCheckLogEmail.action?empCheckLogEmail.empCheckLogEmailId=%{#empCheckLogEmail.empCheckLogEmailId}" onclick="return del();">删除</s:a></td>
				<td><s:checkbox id="empCheckLogEmailIds" name="empCheckLogEmailIds" value="false" fieldValue="%{#empCheckLogEmail.empCheckLogEmailId}" theme="simple"/></td>
			</tr>
		</s:iterator>
	</table>	
	
	<input type="button" value="全选" onClick="selectAll('empCheckLogEmailIds')" />   
    <input type="button" value="反选" onClick="selectRverse('empCheckLogEmailIds')" />   
    <input type="button" value="删除选中信息" onClick="delSelected('empCheckLogEmailIds')" /> 
-->
  
  
		<div style="width:99%; height:99%; border: 1px red solid; padding-left: 5px;"  align="left">
			<strong style="color:#F00">显示所有部门：</strong>
		    <s:select list="#request.listDep" name="depListSelect" listKey="depId" listValue="depName" headerValue="--请选择部门--" headerKey="0" onchange="invokeDep(this.value,this.options[this.selectedIndex].text)" ></s:select>
			  
			  <div style="border:1px solid #4395de; padding-top:5px; padding-left:5px; height:60%;overflow-y:auto; overflow-x:hidden; width:98%;">
			  	<strong style="color:blue;">以下显示各部门部门员工信息</strong>
			  	<s:form action="saveOrUpdateEmpCheckLogEmail">
				 	 <div id="empDiv" style="border-top: 1px red solid; border-bottom: 1px red solid; width:98%;"> 
				 	    <img id="loadingImg" name="loadingImg" src="${ctx}/img/downLoading1.gif" style="display: none;"/> 
				 	    <s:hidden id="empIdUser" name="empIdUser" value="%{#session.EMP_SESSION.empId}"></s:hidden><!--发送人Id -->
				 		<s:hidden id="empIdArrayStr" name="empIdArrayStr"  value=""></s:hidden><!-- 指定接收人Id字符串隐藏域1,2,3,4,5 -->
				 	</div>
				 	<div style="width: 990px;" align="right"><s:submit id="sub" name="sub" value="提                交" onclick="checkedEmpSubimt()" disabled="true"></s:submit></div>
			  	</s:form>
			   </div> 
			   <strong style="color:red;">指定收件人员：</strong>
			   <div style="border:1px #4395de solid; padding-left:10px; height:28%;overflow-y:auto; overflow-x:hidden; width: 98%;">
  					<s:iterator value="#request.listEmpCheckLogEmail" id="empCheckLogEmail" status="st">
  						
  						<s:checkbox id="empCheckLogEmailIds" name="empCheckLogEmailIds" value="false" fieldValue="%{#empCheckLogEmail.empCheckLogEmailId}" theme="simple"/>
					    <span style="color: red;"><s:property value="#empCheckLogEmail.empByCheckEmpId.empName" default="无"/></span>
						<!-- %指定好，#在页面获得的id -->
						<s:a href="removeEmpCheckLogEmail.action?empCheckLogEmail.empCheckLogEmailId=%{#empCheckLogEmail.empCheckLogEmailId}" onclick="return del();">删除</s:a>
						<s:if test="#st.modulus(10)==0">
  						   <br />
  						</s:if>
  					</s:iterator>
  			  </div>			
			  <div style="width: 98%;" align="right">
				  <input type="button" value="全选" onClick="selectAll('empCheckLogEmailIds')" />   
				  <input type="button" value="反选" onClick="selectRverse('empCheckLogEmailIds')" />   
				  <input type="button" value="删除选中收件人员信息" onClick="delSelected('empCheckLogEmailIds')" /> 
			  </div>  
		</div>	    
	</body>
</html>
