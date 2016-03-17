<%@ page language="java" pageEncoding="GBK"%>  
<%@include file="/commons/taglibs.jsp"%>
<html>  
    <head>  
        <title>chat</title>  
        <meta http-equiv="pragma" content="no-cache">  
        <meta http-equiv="cache-control" content="no-cache">  
        <meta http-equiv="expires" content="0">  
        <script type='text/javascript' src="${ctx}/dwr/interface/ChatManager.js"></script>  
        <script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
		<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
        <script type="text/javascript" src="chat.js"></script>  
    </head>  
    <body>  
        <input type="hidden" name="userid" />  
        <br>  
        昵称:   
        <input type="text" name="username" />  
        <input type="button" value="注册" onclick="register(this);" />  
        <br />  
        <br />  
        我要对   
        <select name="receiver" id="receiver" disabled=true" >  
        </select>  
        说:   
        <input type="text" name="message" id="message" disabled="true" />  
        <input type="button" value="发送" id="send" name="send" disabled="true"  
            onclick="send();" />  
        <br />  
        <br />  
        在线用户列表:   
        <ul id="users">  
        </ul>  
  
        <div id="showMessage" style="display: none">  
            <span id="sender"></span>对你说:   
            <span id="msg"></span>  
        </div>  
    </body>  
</html>  
