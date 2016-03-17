package com.emplog.dao;

import java.util.List;

import com.emplog.bean.Emp;

public interface EmpDao {
	public void saveEmp(Emp emp);
	public List<Emp> findAllEmp();
	public void removeEmp(Emp emp);
	public void updateEmp(Emp emp);
	public Emp findEmpByEmpId(Integer empId);
	public List<Emp> findEmpsByDepId(Integer depId);
	public List<Emp> findEmpsByEmpName(String empName);
	public void removeEmpById(Integer empId);
	public Integer findTotalRow();
	public List<Emp> findPageByPageTotalRowAndPage(Integer pageTotalRow,Integer pageSize);
	
	public List<Emp> findEmpByEmpNameAndEmpPassword(String empName,String empPassword);
	
}
