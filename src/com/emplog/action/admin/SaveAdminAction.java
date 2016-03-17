package com.emplog.action.admin;

import com.opensymphony.xwork2.ActionSupport;

import com.emplog.bean.Admin;
import com.emplog.service.AdminService;

/*
 * 完成数据收集和校验的工作
 */
public class SaveAdminAction extends ActionSupport{
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
		//调用service相关的方法，完成实际的业务处理
		this.service.saveAdmin(this.admin);
		return SUCCESS;
	}

	
}
