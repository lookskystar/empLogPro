
  <!--%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!--%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <!--%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <!--%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
  <!--%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<!--%@taglib prefix="ec" uri="http://www.extremecomponents.org" %>-->

<%@ page contentType="text/html; charset=UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>


<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>


<c:set value="<%=request.getContextPath()%>" var="ctx"></c:set>



<!--jquery 顶部动态菜单插件-->
<script src="${ctx}/util/jquery-1.6.min.js" type="text/javascript"></script>
<script src="${ctx}/util/kwicks/js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="${ctx}/util/kwicks/js/jquery.kwicks-1.5.1.pack.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/util/kwicks/css/main.css" />









<!-- jquery 在线文本编辑器 -->
<script type="text/javascript" src="${ctx}/util/xheditor/xheditor-1.1.6-zh-cn.min.js"></script>



	

<!-- js日历控件 -->
<script language="javascript" type="text/javascript" src="${ctx}/util/My97DatePicker/WdatePicker.js"></script>

<!-- 自定义样式 -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />



<!-- extjs3.3.1 插件  因为不能使用UploadDialog插件，所以启用-->
<!-- 
引入extjs样式及库文件 ext-base.js表示框架基础库，是extjs的核心库。 adapter表示适配器，也就是说可以有多种适配器，因此
可以把adapter/ext/ext-base.js换成adapter/jquery/ext-jquery-adapter.js或其他的adapter/prototype/ext-prototype-adapter.js等

<link rel="stylesheet" type="text/css" href="${ctx}/util/extjs3/ext-all.css" />
<link rel="stylesheet" type="text/css"  href="${ctx}/util/UploadDialog/css/Ext.ux.UploadDialog.css" />
<script type="text/javascript" src="${ctx}/util/extjs3/ext-base.js"></script>
<script type="text/javascript" src="${ctx}/util/extjs3/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/util/extjs3/ext-lang-zh_CN.js"></script>-->
<!-- extjs上传组件
<script type="text/javascript" src="${ctx}/util/UploadDialog/UploadDialog.js"></script>
<script type="text/javascript" src="${ctx}/util/UploadDialog/locale/ru.utf-8.js"></script>--> 


<!-- extjs2.2.1 插件  能使用UploadDialog插件-->
<link href="${ctx}/util/ext/resources/css/ext-all.css" rel="stylesheet" type="text/css">
<link href="${ctx}/util/UploadDialog/css/Ext.ux.UploadDialog.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/util/ext/adapter/ext/ext-base.js"> </script> <!--必须放在ext-all.js之前-->
<script type="text/javascript" src="${ctx}/util/ext/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/util/UploadDialog/Ext.ux.UploadDialog.js"></script>
<script type="text/javascript" src="${ctx}/util/UploadDialog/locale/ru.utf-8_zh.js"></script>

