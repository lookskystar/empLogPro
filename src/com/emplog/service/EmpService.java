package com.emplog.service;

import java.util.List;

import com.emplog.bean.Emp;

public interface EmpService {
	public void saveEmp(Emp emp);
	public List<Emp> findAllEmp();
	public void removeEmp(Emp emp);
	public void updateEmp(Emp emp);
	public Emp findEmpByEmpId(Integer empId);
	public List<Emp> findEmpsByDepId(Integer depId);
	public boolean findEmpsByEmpName(String empName);
	public void removeEmpById(String empIds);
	public Integer findTotalRow();
	public Integer findTotalPage(Integer pageSize);
	public Integer findPageTotalRow(Integer page,Integer pageSize);
	public List<Emp> findPageByPageTotalRowAndPage(int pageSize,int page);
	
	public boolean checkEmpNameSaveEmp(Emp emp);
	
	public Emp findEmpByEmpNameAndEmpPassword(String empName, String empPassword);
}
