package com.emplog.action.empCheckLogEmail;

import java.util.Map;

import com.emplog.service.DepService;
import com.emplog.service.EmpCheckLogEmailService;
import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindDepEmpToAssigEmpEmailJspAction extends ActionSupport {
	private DepService depService;
	private EmpService empService;
	private EmpCheckLogEmailService EmpCheckLogEmailService;
	
	public DepService getDepService() {
		return depService;
	}

	public void setDepService(DepService depService) {
		this.depService = depService;
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public EmpCheckLogEmailService getEmpCheckLogEmailService() {
		return EmpCheckLogEmailService;
	}

	public void setEmpCheckLogEmailService(
			EmpCheckLogEmailService empCheckLogEmailService) {
		EmpCheckLogEmailService = empCheckLogEmailService;
	}

	@Override
	public String execute() throws Exception {
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("listDep", this.depService.findAllDep());
		request.put("listEmpCheckLogEmail", this.EmpCheckLogEmailService.findAllByEmpId(4));
		return SUCCESS;
	}
}
