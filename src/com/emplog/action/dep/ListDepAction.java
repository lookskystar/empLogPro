package com.emplog.action.dep;

import java.util.Map;

import com.emplog.service.DepService;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListDepAction extends ActionSupport {
 
	
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
