
package com.emplog.action.emp;

import java.util.Map;

import com.emplog.bean.Emp;
import com.emplog.service.DepService;
import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindEmpByEmpIdAction extends ActionSupport {
	
	private Emp emp;
	private EmpService empService;
	private DepService depService;
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	public EmpService getEmpService() {
		return empService;
	}
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	

	public DepService getDepService() {
		return depService;
	}
	public void setDepService(DepService depService) {
		this.depService = depService;
	}
	@Override
	public String execute() throws Exception {
		//得到所有dep
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", this.depService.findAllDep());
		//根据id得到emp
		this.emp=this.empService.findEmpByEmpId(emp.getEmpId());
		
		return SUCCESS;
	}
}
