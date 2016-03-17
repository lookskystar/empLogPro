package com.emplog.util;

import java.util.ArrayList;   
import java.util.List;   
  
import javax.servlet.ServletContext;   
import javax.servlet.ServletContextEvent;   
import javax.servlet.ServletContextListener;   
import javax.servlet.http.HttpSessionAttributeListener;   
import javax.servlet.http.HttpSessionBindingEvent;   
import javax.servlet.http.HttpSessionEvent;   
import javax.servlet.http.HttpSessionListener; 

import com.emplog.bean.Emp;

public class OnlineDemo implements ServletContextListener, HttpSessionListener,   
HttpSessionAttributeListener {
	
	// ����һ��ServletContext����   
    private ServletContext application = null;   


	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//context��ʼ��ʱ����  
	public void contextInitialized(ServletContextEvent sce) {
		// ������ʼ��ʱ����application�д��һ���յ�����   
		//System.out.println("������ʼ��ʱ����application�д��һ���յ�����  +contextInitialized");
        this.application = sce.getServletContext();   
        this.application.setAttribute("ALLEMP_APPLICATION", new ArrayList());   

		
	}

	//����һ��sessionʱ����  
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//��һ��sessionʧЧʱ���� 
	public void sessionDestroyed(HttpSessionEvent se) {
		// ���û����ƴ��б���ɾ��   
		//System.out.println("���û����ƴ��б���ɾ��  +sessionDestroyed");
        List l = (List) this.application.getAttribute("ALLEMP_APPLICATION");   
        String value = (String) se.getSession().getAttribute("ALLEMP_APPLICATION");   
        l.remove(value);   
        this.application.setAttribute("ALLEMP_APPLICATION", l);   

		
	}

	//����һ���µ�����ʱ����
	public void attributeAdded(HttpSessionBindingEvent se) {
		 // �����½�ɹ������û����������б�֮��   
		//System.out.println("�����½�ɹ������û����������б�֮�� +attributeAdded");
        List l = (List) this.application.getAttribute("ALLEMP_APPLICATION");  
        System.out.println("---->"+((Emp)se.getValue()).getEmpName());
        l.add(se.getValue());   
        //System.out.println("--------l--->"+l.size());
//        for (int i = 0; i < l.size(); i++) {
//			System.out.println(((Emp)l.get(i)).getEmpName());
//		}
        this.application.setAttribute("ALLEMP_APPLICATION", l);   

		
	}

	//ɾ��һ���µ�����ʱ���� 
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//���Ա����ʱ����  
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
