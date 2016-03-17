package com.emplog.action.emp;

import java.util.Map;

import com.emplog.bean.Emp;
import com.emplog.service.EmpService;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class FindEmpByEmpNameAndEmpPasswordAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletContextAware {
	private Emp emp;
	private EmpService service;
	
	private Map session;
	private HttpServletRequest request;
	private ServletContext application;


	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public EmpService getService() {
		return service;
	}
	public void setService(EmpService service) {
		this.service = service;
	}
	
	
	public void setSession(Map session) {
        this.session = session ;
   }
	
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
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


	@Override
	public String execute() throws Exception { 
		
		Emp empObj=null;
		empObj = (Emp) Class.forName("com.emplog.bean.Emp").newInstance();
		empObj= this.service.findEmpByEmpNameAndEmpPassword(this.emp.getEmpName(), this.emp.getEmpPassword());
	   
		if((this.emp.getEmpName()).equals(empObj.getEmpName())&&(this.emp.getEmpPassword()).equals(empObj.getEmpPassword())){

			//两种方式得到session ，IOC方式和非IOC方式
			this.session.put("EMP_SESSION", empObj); 
//			List l = (List) this.application.getAttribute("ALLEMP_APPLICATION");   
//	        for (int i = 0; i < l.size(); i++) {
//				System.out.println("-------llaction:-->"+((Emp)(l.get(i))).getEmpName());
//			} 
			
			return SUCCESS;
			
			
		
		}
		return ERROR;
	}

	
	
}
