package com.emplog.action.admin;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.emplog.bean.Admin;
import com.emplog.bean.Emp;
import com.emplog.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class FindAdminByAdminNameAndAdminPassword extends ActionSupport implements SessionAware,ServletRequestAware,ServletContextAware{
	private Admin admin;
	private AdminService service;
	
	private Map session;
	private HttpServletRequest request;
	private ServletContext application;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminService getService() {
		return service;
	}
	public void setService(AdminService service) {
		this.service = service;
	}
	
	
	public void setSession(Map session) {
        this.session = session ;
   }
	
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application = application;
	}
	public void geetServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application = application;
	}
	
	

	public String execute() throws Exception {
		Admin adminObj=null;
		adminObj = (Admin) Class.forName("com.emplog.bean.Admin").newInstance();
	    adminObj= this.service.findAdminByAdminNameAndAdminPassword(this.admin.getAdminName(), this.admin.getAdminPassword());
	   
		if((this.admin.getAdminName()).equals(adminObj.getAdminName())&&(this.admin.getAdminPassword()).equals(adminObj.getAdminPassword())){

			//两种方式得到session ，IOC方式和非IOC方式,admin和emp放在一个session中，也就是EMP_SESSION
			this.session.put("EMP_SESSION", adminObj); 
//			List l = (List) this.application.getAttribute("ALLEMP_APPLICATION");   
//	        for (int i = 0; i < l.size(); i++) {
//				System.out.println("-------llaction:-->"+((Emp)(l.get(i))).getEmpName());
//			} 
			
			return SUCCESS;
			
			
		
		}
		return ERROR;
	}
	
	

	
	

}
