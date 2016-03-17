package com.emplog.action.dep;

import java.util.List;
import java.util.Map;



import com.emplog.bean.Dep;
import com.emplog.bean.Emp;
import com.emplog.service.DepService;
import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveDepAction extends ActionSupport {
	private Dep dep;
	private Emp emp;
	private DepService depService;
	private EmpService empService;
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
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
	@Override
	public String execute() throws Exception {
		//删除前先看此部门还有无员工
	
		//根据部门id查找所有员工
		List<Emp> list=this.empService.findEmpsByDepId(this.dep.getDepId());
		
		if(list.size()!=0){
			
			Map request=(Map)ActionContext.getContext().get("request");
			String name=list.get(1).getDep().getDepName();
			String msg="请先删除此<"+name+">下得员工，或修改员工为其他部门，再删除此部门....";
			
			request.put("list", list);
			request.put("msg", msg);
	
			return "listEmp";			
		}
		
		this.depService.removeDep(this.dep);
		return SUCCESS;
	}
}
