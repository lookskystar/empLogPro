<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>显示员工树</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- dwr -->
	<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
	<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
	<script type='text/javascript' src="${ctx}/dwr/interface/depService.js"></script> 
	
	
	<script language="javaScript" src="${ctx}/util/feihutree/MzTreeView12.js"></script>
	<script language="javaScript" src="${ctx}/util/feihutree/jquery-1.6.min.js"></script>
	
	
	<style>
		body {font:normal 12px 宋体}
		a.MzTreeview /* TreeView 链接的基本样式 */ { cursor: hand; color: #000080; margin-top: 5px; padding: 2 1 0 2; text-decoration: none; }
		.MzTreeview a.select /* TreeView 链接被选中时的样式 */ { color: highlighttext; background-color: highlight; }
		#kkk input {
		vertical-align:middle;
		}
		.MzTreeViewRow {border:none;width:500px;padding:0px;margin:0px;border-collapse:collapse}
		.MzTreeViewCell0 {border-bottom:1px solid #CCCCCC;padding:0px;margin:0px;}
		.MzTreeViewCell1 {border-bottom:1px solid #CCCCCC;border-left:1px solid #CCCCCC;width:200px;padding:0px;margin:0px;}
	</style>
	
	
	
	

</head>
  
  <body>
   <!--  <table class='MzTreeViewRow' style="background:#EEEEEE;border-top:1px solid #CCCCCC;"><tr><th class='MzTreeViewCell0'>树</th></tr></table>-->

 <div id="kkk"></div> 


<script language="javascript" type="text/javascript">


			


            
			//树控件
			//var MzTreeViewTH="<table class='MzTreeViewRow'><tr><td class='MzTreeViewCell0'>";
			//var MzTreeViewTD="\"</td><td class='MzTreeViewCell1'>\"+ sid +\"</td></tr></table>\"";
			
			window.tree = new MzTreeView("tree");
			
			tree.icons["property"] = "property.gif";
			tree.icons["css"] = "collection.gif";
			tree.icons["event"] = "collection.gif";
			tree.icons["book"]  = "book.gif";
			tree.iconsExpand["book"] = "bookopen.gif"; //展开时对应的图片

			tree.setIconPath("/empLogssh2/util/jquery-mztree/images/"); //可用相对路径
			
			 //DWR
			function invoke(){
			    depService.findAllDep(function(data){
			     
			     
			    /* 
			     tree=(TreeBean)v.get(i);
			    node = "    tree.nodes[\""+tree.getParentId()+"_"+tree.getId()+"\"] = \"";
			    node +="text:"+ tree.getText().trim() +";";
			    if(!tree.getHint().trim().equalsIgnoreCase("")) node +="hint:"+tree.getHint().trim()+";";
			    if(!tree.getIcon().trim().equalsIgnoreCase("")) node +="icon:"+tree.getIcon().trim()+";";
			  	if(!tree.getData().trim().equalsIgnoreCase("")) node +="data:"+tree.getData().trim()+";";
			  	if(!tree.getUrl().trim().equalsIgnoreCase("")) node +="url:"+tree.getUrl().trim()+";";
			  	if(!tree.getTarget().trim().equalsIgnoreCase("")) node +="target:"+tree.getTarget().trim()+";";
			  	if(!tree.getMethod().trim().equalsIgnoreCase("")) node +="method:"+tree.getMethod().trim()+";";
			    node +="\"" ;
			    //System.out.println(node);
			    out.println(node);
			    */
			     String node="";
	             TreeBean treeBean=new TreeBean();
				  for(var i=0;i<data.length;i++){
						  //tree.N["0_1"] = "ctrl:sel;checked:0;T:系统管理;";
						  //document.write(tree.N["0_1"] );
						  //tree.N["0_1"+i]="ctrl:sel;checked:0;T:系统管理;"
						  //alert(data);
						  //out.print("d.add('"+tree.getJh()+"','"+tree.getQk()+"区块','"+tree.getJh()+"','','','rightFrame');");
						  //out.print("tree.N['0_1']='ctrl:sel;checked:0;T:系统管理;'");
						  //document.write("tree.N['0_1']='ctrl:sel;checked:0;T:系统管理;'");
						  
						   node = "    tree.N[\""+data[i].depId+"_"+data[i].depName+"\"] = \"";
						   node +="\"" ;
						   out.println(node);
				  }
				  

				});
				

			}
			
			invoke();
			//tree.N["0_SH8900000000"] = "ctrl:sel;checked:0;T:系统管理;"
			
			
			
			/*tree.N["0_SH8900000000"] = "ctrl:sel;checked:0;T:系统管理;"
			tree.N["SH8900000000_SH8901000000"] = "ctrl:sel;checked:0;T:文书模板管理;url:workflow/manage/template.asp"
			tree.N["SH8900000000_SH8902000000"] = "ctrl:sel;checked:0;T:自定义流程管理;url:workflow/manage/Services.ASP"
			tree.N["SH8900000000_SH8903000000"] = "ctrl:sel;checked:0;T:质量考核因素;url:workflow/manage/managezl.asp"
			tree.N["SH8900000000_SH8904000000"] = "ctrl:sel;checked:0;T:节假日管理;url:workflow/manage/freeday.asp"
			tree.N["SH8900000000_SH8905000000"] = "ctrl:sel;checked:0;T:事项管理;url:workflow/itemsystem.asp"
			tree.N["SH8900000000_SH8906000000"] = "ctrl:sel;checked:0;T:用户及权限管理;"
			tree.N["SH8900000000_SH8907000000"] = "ctrl:sel;checked:0;T:组织机构管理;"
			tree.N["SH8906000000_SH8906010000"] = "ctrl:sel;checked:0;T:添加新用户;url:SystemManager/User_add.aspx"
			tree.N["SH8907000000_SH8907010000"] = "ctrl:sel;checked:0;T:添加组织机构;url:SystemManager/Org_add.aspx"
			tree.N["SH8906000000_SH8906020000"] = "ctrl:sel;checked:0;T:用户管理;url:SystemManager/User_man.aspx"
			tree.N["SH8907000000_SH8907020000"] = "ctrl:sel;checked:0;T:组织机构管理;url:SystemManager/Org_man.aspx"
			tree.N["SH8906000000_SH8906030000"] = "ctrl:sel;checked:0;T:添加新角色;url:SystemManager/Role_add.aspx"
			tree.N["SH8906000000_SH8906040000"] = "ctrl:sel;checked:0;T:系统角色管理;url:SystemManager/Role_man.aspx"
*/		
			tree.setURL("#");
			tree.wordLine = false;
			tree.setTarget("main");
			document.getElementById("kkk").innerHTML=tree.toString(); //显示在那个容器中
			tree.expandAll();
			
			//alert(document.getElementsByTagName("head")[0].innerHTML);
			//alert(document.getElementById("kkk").innerHTML);
			
			function showsel()
			{
				var es=document.getElementsByName("sel");
				var out="";
				for(var i=0;i<es.length;i++)
				{
					if (es[i].checked) out+=es[i].value+"\n";
				}
				alert(out);
			}
			//-->
	</script>
	
	
	<script language="javascript" type="text/javascript">
$(document).ready(function(){
	//$("#browser>ul>li").find("span").unbind("click.treeview").bind("click.treeview",function(event){alert(event.target.grade+event.target.innerHTML);}).add("a",this);	
   //alert($("#browser>ul>li").find("span").length);
   $("#browser").feihutree({
	   collapsed:true,
	   unique:true
	   });
});
</script>

<style type="text/css">
body,li,span,a{font-size:12px;}
ul,li{list-style:none; padding:0px; margin:0px; }
img{border:0px; vertical-align:middle;}
#browser{}
#browser span{ color:#900; font-weight:bold;cursor:pointer;}
#browser a{
	color:#333;
	text-decoration: none;
}
</style>

<input type="button" name="btn" value="点击" onclick="invoke()">


<div id="browser">
<span>开始</span>
<ul>
<li><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.1</a></li>
<li><span grade="1"><img src="tree_image/_minus1.gif"/><img src="tree_image/folderopen.gif"/>树状菜单1.2</span>
	<ul>
    <li><img src="tree_image/_line4.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.1</a></li>
    <li><img src="tree_image/_line4.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.2</a></li>
    <li><img src="tree_image/_line4.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.3</a></li>
    <li><img src="tree_image/_line4.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.4</a></li>
    <li><img src="tree_image/_line4.gif"/><span grade="2"><img src="tree_image/_minus2.gif"/><img src="tree_image/folderopen.gif"/>树状菜单1.2.5</span>
    	<ul>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line5.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.5.1</a></li>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line5.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.5.2</a></li>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line5.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.5.3</a></li>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line5.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.5.4</a></li>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line5.gif"/><img src="tree_image/_line2.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.5.5</a></li>
        </ul>
    </li>
	</ul>
</li>
<li><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.3</a></li>
<li><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.4</a></li>
<li><span grade="1"><img src="tree_image/_minus1.gif"/><img src="tree_image/folderopen.gif"/>树状菜单1.5</span>
	<ul>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.5.1</a></li>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.5.2</a></li>
    	<li><img src="tree_image/_line4.gif"/><img src="tree_image/_line2.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.5.3</a></li>
    </ul>
</li>
<li><img src="tree_image/_line2.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.6</a></li>
</ul>
</div>


  </body>
</html>
