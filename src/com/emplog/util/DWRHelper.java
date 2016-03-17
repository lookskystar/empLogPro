package com.emplog.util;


import java.util.Collection;   

import org.directwebremoting.ScriptSession;   
import org.directwebremoting.WebContext;   
import org.directwebremoting.WebContextFactory;   
import org.directwebremoting.proxy.dwr.Util; 

public class DWRHelper {
	public void addMessage(String text) {   
        System.out.println("客户端传来：" + text);   
  
        WebContext wctx = WebContextFactory.get();   
        String currentPage = wctx.getCurrentPage();   
        System.out.println("currentPage:" + currentPage);   
  
        // 通过scriptsession调用js函数，操作dom。就像我们给sessson中放置内容一样轻松。   
        // 获得正在交互的浏览器上下文：ScriptSession,再得到工具Util   
        Util utilThis = new Util(wctx.getScriptSession());   
        utilThis.setValue("text", ""); // 操作客户端DOM模型！   
        utilThis.addFunctionCall("ggg", "服务器数据！"); // 执行客户端的函数！   
  
        // 获得正在访问chat.jsp所有的浏览器客户端.在服务器端直接调用操作所有客户端内容   
        Collection<ScriptSession> sessions = wctx   
                .getScriptSessionsByPage(currentPage);   
  
        // 用户每点一次刷新就会生成新的scriptsession对象。   
        // 所以，为了有效管理scriptsession，我们专门维护一个map.   
  
        for (ScriptSession object : sessions) {   
            System.out.println("ScriptSessionID:" + object.getId());   
        }   
  
        Util utilAll = new Util(sessions);   
        // 调用一个客户端的js函数！   
        utilAll.addFunctionCall("addChatMsg", text);   
    }   

}
