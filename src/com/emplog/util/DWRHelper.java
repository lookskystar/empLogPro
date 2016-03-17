package com.emplog.util;


import java.util.Collection;   

import org.directwebremoting.ScriptSession;   
import org.directwebremoting.WebContext;   
import org.directwebremoting.WebContextFactory;   
import org.directwebremoting.proxy.dwr.Util; 

public class DWRHelper {
	public void addMessage(String text) {   
        System.out.println("�ͻ��˴�����" + text);   
  
        WebContext wctx = WebContextFactory.get();   
        String currentPage = wctx.getCurrentPage();   
        System.out.println("currentPage:" + currentPage);   
  
        // ͨ��scriptsession����js����������dom���������Ǹ�sessson�з�������һ�����ɡ�   
        // ������ڽ���������������ģ�ScriptSession,�ٵõ�����Util   
        Util utilThis = new Util(wctx.getScriptSession());   
        utilThis.setValue("text", ""); // �����ͻ���DOMģ�ͣ�   
        utilThis.addFunctionCall("ggg", "���������ݣ�"); // ִ�пͻ��˵ĺ�����   
  
        // ������ڷ���chat.jsp���е�������ͻ���.�ڷ�������ֱ�ӵ��ò������пͻ�������   
        Collection<ScriptSession> sessions = wctx   
                .getScriptSessionsByPage(currentPage);   
  
        // �û�ÿ��һ��ˢ�¾ͻ������µ�scriptsession����   
        // ���ԣ�Ϊ����Ч����scriptsession������ר��ά��һ��map.   
  
        for (ScriptSession object : sessions) {   
            System.out.println("ScriptSessionID:" + object.getId());   
        }   
  
        Util utilAll = new Util(sessions);   
        // ����һ���ͻ��˵�js������   
        utilAll.addFunctionCall("addChatMsg", text);   
    }   

}
