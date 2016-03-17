<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<%   
String path = request.getContextPath();   
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <base href="<%=basePath%>">  
  
        <title>My JSP 'index.jsp' starting page</title>  
        <meta http-equiv="pragma" content="no-cache">  
        <meta http-equiv="cache-control" content="no-cache">  
        <meta http-equiv="expires" content="0">  
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
        <meta http-equiv="description" content="This is my page">  
        <script type='text/javascript' src='dwr/util.js'></script>  
        <script type='text/javascript' src='dwr/engine.js'></script>  
        <script type='text/javascript' src='dwr/interface/DWRHelper.js'></script>  
        <script type="text/javascript">  
                function sendMessage() {   
                  DWRHelper.addMessage($("text").value);   
                }   
                function  addChatMsg(msg){   
                    var d2 = document.createElement("div");   
                    d2.innerHTML=msg;   
                    $("div1").appendChild(d2);   
                }   
                   
                function ggg(g){   
                    alert("ggg:"+g);   
                }   
        </script>  
    </head>  
  
    <body onload="dwr.engine.setActiveReverseAjax(true);">  
        聊天记录：   
        <div id="div1">  
        </div>  
  
        我说：   
        <input id="text" />  
        <input type="button" value="Send" onclick="sendMessage()" />  
        </p>  
  
        <hr />  
    </body>  
  
</html>  
