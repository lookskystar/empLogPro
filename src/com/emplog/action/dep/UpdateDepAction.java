package com.emplog.action.dep;

import com.emplog.bean.Dep;
import com.emplog.service.DepService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateDepAction extends ActionSupport {
	private Dep Dep;
	private DepService service;
	public Dep getDep() {
		return Dep;
	}
	public void setDep(Dep Dep) {
		this.Dep = Dep;
	}
	public DepService getService() {
		return service;
	}
	public void setService(DepService service) {
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception {
		this.service.updateDep(Dep);
		return SUCCESS;
	}
}
