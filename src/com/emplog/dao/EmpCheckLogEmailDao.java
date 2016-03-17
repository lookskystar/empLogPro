package com.emplog.dao;

import java.util.List;


import com.emplog.bean.EmpCheckLogEmail;

public interface EmpCheckLogEmailDao {
	public void saveEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail);
	public List<EmpCheckLogEmail> findAllEmpCheckLogEmail();
	public void removeEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail);
	public void updateEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail);
	public void removeEmpCheckLogEmailByEmpId(Integer empId);
	public List findAllByEmpId(Integer empId);
	public List<EmpCheckLogEmail> findByDepIdAndEmpId(Integer empByEmpId,Integer empByCheckEmpId);
	public void saveOrUpdateEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail);
	public void removeEmpCheckLogEmailByEmpCheckLogEmailId(Integer empCheckLogEmailId);
}
