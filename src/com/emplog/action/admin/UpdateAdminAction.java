package com.emplog.action.admin;

import com.emplog.bean.Admin;
import com.emplog.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAdminAction extends ActionSupport {
	private Admin admin;
	private AdminService service;
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
	
	@Override
	public String execute() throws Exception {
		this.service.updateAdmin(admin);
		return SUCCESS;
	}
}
