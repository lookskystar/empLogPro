package com.emplog.action.admin;

import com.opensymphony.xwork2.ActionSupport;

import com.emplog.bean.Admin;
import com.emplog.service.AdminService;

/*
 * ��������ռ���У��Ĺ���
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
		//����service��صķ��������ʵ�ʵ�ҵ����
		this.service.saveAdmin(this.admin);
		return SUCCESS;
	}

	
}
