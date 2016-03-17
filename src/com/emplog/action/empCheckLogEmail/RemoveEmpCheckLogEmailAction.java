package com.emplog.action.empCheckLogEmail;

import com.emplog.bean.EmpCheckLogEmail;
import com.emplog.service.EmpCheckLogEmailService;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveEmpCheckLogEmailAction extends ActionSupport {
	private EmpCheckLogEmailService service;
	private EmpCheckLogEmail empCheckLogEmail;
	private String empCheckLogEmailIds;
	
	public EmpCheckLogEmailService getService() {
		return service;
	}
	public void setService(EmpCheckLogEmailService service) {
		this.service = service;
	}
	public EmpCheckLogEmail getEmpCheckLogEmail() {
		return empCheckLogEmail;
	}
	public void setEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		this.empCheckLogEmail = empCheckLogEmail;
	}
	public String getEmpCheckLogEmailIds() {
		return empCheckLogEmailIds;
	}
	public void setEmpCheckLogEmailIds(String empCheckLogEmailIds) {
		this.empCheckLogEmailIds = empCheckLogEmailIds;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		String empCheckLogEmailIds=this.empCheckLogEmailIds;
		//Ա��Id�ַ��������Ϊnull��ɾ��һ���������null������ɾ��
		if(empCheckLogEmailIds==null){
			this.service.removeEmpCheckLogEmailByEmpCheckLogEmailId(this.empCheckLogEmail.getEmpCheckLogEmailId());
		}else{
				this.service.removeEmpCheckLogEmailByEmpCheckLogEmailIds(empCheckLogEmailIds);
		}
		return SUCCESS;
		
	}
}
