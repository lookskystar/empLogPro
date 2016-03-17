package com.emplog.action.emp;

import java.util.Map;

import com.emplog.bean.Emp;
import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SaveEmpAction extends ActionSupport{
	private Emp emp;
	private EmpService service;
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public EmpService getService() {
		return service;
	}

	public void setService(EmpService service) {
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception {
		//this.service.saveEmp(emp); 
		if(this.service.checkEmpNameSaveEmp(emp)){
			//Ա����������
			return SUCCESS;
		}else{
			//Ա��������
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("msg", "��Ա�����Ѵ���,������!");
			return ERROR;
		}                                                                                                                                                                      
	}
	
}
