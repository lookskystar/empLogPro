package com.emplog.action.emp;

import java.util.Map;

import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListEmpAction extends ActionSupport{
	private EmpService service;

	public EmpService getService() {
		return service;
	}

	public void setService(EmpService service) {
		this.service = service;
	}
	
	
	@Override
	public String execute() throws Exception {
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", this.service.findAllEmp());
				
		return super.execute();
	}
}
