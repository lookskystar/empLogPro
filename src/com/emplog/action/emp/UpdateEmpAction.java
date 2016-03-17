package com.emplog.action.emp;

import com.emplog.bean.Emp;
import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateEmpAction extends ActionSupport {
	private Emp emp;
	private EmpService service;
	
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

	@Override
	public String execute() throws Exception {		
		this.service.updateEmp(emp);
		return SUCCESS;
	}
}
