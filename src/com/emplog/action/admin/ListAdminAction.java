package com.emplog.action.admin;

import java.util.Map;

import com.emplog.service.AdminService;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAdminAction extends ActionSupport {
	private AdminService service;

	public AdminService getService() {
		return service;
	}

	public void setService(AdminService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
        Map request = (Map)ActionContext.getContext().get("request");
		
		request.put("list", this.service.findAll());
		
		return SUCCESS;
	}
	
	
	
}
