package com.emplog.action.dep;

import com.emplog.bean.Dep;
import com.emplog.service.DepService;
import com.opensymphony.xwork2.ActionSupport;

public class SaveDepAction extends ActionSupport{
	private Dep dep;
	private DepService service;
	
	
	public Dep getDep() {
		return dep;
	}


	public void setDep(Dep dep) {
		this.dep = dep;
	}


	public DepService getService() {
		return service;
	}


	public void setService(DepService service) {
		this.service = service;
	}


	@Override
	public String execute() throws Exception {
		this.service.saveDep(dep);
		return SUCCESS;
	}
	
}
