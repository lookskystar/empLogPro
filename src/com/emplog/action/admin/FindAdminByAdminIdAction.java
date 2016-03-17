package com.emplog.action.admin;

import com.emplog.bean.Admin;
import com.emplog.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class FindAdminByAdminIdAction extends ActionSupport {
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
		//System.out.println("--0--£º"+admin.getAdminId());
		this.admin=this.service.findAdminByAdminId(admin.getAdminId());
		return SUCCESS;
	}
}
