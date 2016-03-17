package com.emplog.action.emp;

import com.emplog.bean.Emp;
import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;


public class RemoveEmpAction extends ActionSupport{
	private Emp emp;
	private EmpService service;
	private String empIds;
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public String getEmpIds() {
		return empIds;
	}
	public void setEmpIds(String empIds) {
		this.empIds = empIds;
	}
	public EmpService getService() {
		return service;
	}
	public void setService(EmpService service) {
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception {
		String empIds=this.empIds;
		//员工Id字符串，如果为null则删除一个，如果不null则批量删除
		if(empIds==null){
			this.service.removeEmp(emp);
		}else{
				this.service.removeEmpById(empIds);
		}
		return SUCCESS;
	}

}
