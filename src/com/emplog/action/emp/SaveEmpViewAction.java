package com.emplog.action.emp;


import java.util.Map;


import com.emplog.service.DepService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveEmpViewAction extends ActionSupport {
	
	private DepService service;
	
	public void setService(DepService service) {
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception {
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", this.service.findAllDep());
		return SUCCESS;
	}
}
