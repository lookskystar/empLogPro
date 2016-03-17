package com.emplog.action.empCheckLogEmail;


import com.emplog.bean.EmpCheckLogEmail;
import com.emplog.service.EmpCheckLogEmailService;
import com.opensymphony.xwork2.ActionSupport;

public class SaveOrUpdateEmpCheckLogEmailAction extends ActionSupport{
	private EmpCheckLogEmailService service;
	private EmpCheckLogEmail empCheckLogEmai;
	
	private String empIdArrayStr; //指定接收人Id字符1,2,3,4,5
	private String empIdUser;	  //发送人id
	

	
	
	public EmpCheckLogEmailService getService() {
		return service;
	}
	public void setService(EmpCheckLogEmailService service) {
		this.service = service;
	}
	public EmpCheckLogEmail getEmpCheckLogEmai() {
		return empCheckLogEmai;
	}
	public void setEmpCheckLogEmai(EmpCheckLogEmail empCheckLogEmai) {
		this.empCheckLogEmai = empCheckLogEmai;
	}
	public String getEmpIdArrayStr() {
		return empIdArrayStr;
	}
	public void setEmpIdArrayStr(String empIdArrayStr) {
		this.empIdArrayStr = empIdArrayStr;
	}
	
	public String getEmpIdUser() {
		return empIdUser;
	}
	public void setEmpIdUser(String empIdUser) {
		this.empIdUser = empIdUser;
	}
	
	@Override
	public String execute() throws Exception {
		String empIdArrayStr=this.getEmpIdArrayStr();
		String empIdUser=this.getEmpIdUser();
		
		
		if(empIdArrayStr.length()==0||empIdUser.length()==0){
			return ERROR;
		}
		else{		
			this.service.saveOrUpdateEmpCheckLogEmail(empIdUser, empIdArrayStr);
			return SUCCESS;
		} 
	}


}
