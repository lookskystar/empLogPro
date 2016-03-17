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
<li><img src="${ctx}/util/feihutree/tree_image/_line1.gif"/><img src="${ctx}/util/feihutree/tree_image/file.gif"/><a href="#">树状菜单1.1</a></li>
<li><span grade="1"><img src="${ctx}/util/feihutree/tree_image/_minus1.gif"/><img src="${ctx}/util/feihutree/tree_image/folderopen.gif"/>树状菜单1.2</span>
	<ul>
    <li><img src="${ctx}/util/feihutree/tree_image/_line4.gif"/><img src="${ctx}/util/feihutree/tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.1</a></li>
    <li><img src="${ctx}/util/feihutree/tree_image/_line4.gif"/><img src="${ctx}/util/feihutree/tree_image/_line1.gif"/><img src="tree_image/file.gif"/><a href="#">树状菜单1.2.2</a></li>
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
