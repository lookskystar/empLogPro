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
	
	// 声明一个ServletContext对象   
    private ServletContext application = null;   


	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//context初始化时激发  
	public void contextInitialized(ServletContextEvent sce) {
		// 容器初始化时，向application中存放一个空的容器   
		//System.out.println("容器初始化时，向application中存放一个空的容器  +contextInitialized");
        this.application = sce.getServletContext();   
        this.application.setAttribute("ALLEMP_APPLICATION", new ArrayList());   

		
	}

	//创建一个session时激发  
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//当一个session失效时激发 
	public void sessionDestroyed(HttpSessionEvent se) {
		// 将用户名称从列表中删除   
		//System.out.println("将用户名称从列表中删除  +sessionDestroyed");
        List l = (List) this.application.getAttribute("ALLEMP_APPLICATION");   
        String value = (String) se.getSession().getAttribute("ALLEMP_APPLICATION");   
        l.remove(value);   
        this.application.setAttribute("ALLEMP_APPLICATION", l);   

		
	}

	//增加一个新的属性时激发
	public void attributeAdded(HttpSessionBindingEvent se) {
		 // 如果登陆成功，则将用户名保存在列表之中   
		//System.out.println("如果登陆成功，则将用户名保存在列表之中 +attributeAdded");
        List l = (List) this.application.getAttribute("ALLEMP_APPLICATION");  
        System.out.println("---->"+((Emp)se.getValue()).getEmpName());
        l.add(se.getValue());   
        //System.out.println("--------l--->"+l.size());
//        for (int i = 0; i < l.size(); i++) {
//			System.out.println(((Emp)l.get(i)).getEmpName());
//		}
        this.application.setAttribute("ALLEMP_APPLICATION", l);   

		
	}

	//删除一个新的属性时激发 
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//属性被替代时激发  
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
