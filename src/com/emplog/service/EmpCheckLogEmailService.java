package com.emplog.service;

import java.util.List;


import com.emplog.bean.EmpCheckLogEmail;

public interface EmpCheckLogEmailService {
	public void saveEmpCheckLogEmail(String empIdUser,String empIdArrayStr);
	public List<EmpCheckLogEmail> findAllEmpCheckLogEmail();
	public void removeEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail);
	public void updateEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail);
	public void removeEmpCheckLogEmailByEmpId(Integer empId);
	public List<EmpCheckLogEmail> findAllByEmpId(Integer empId);
	public EmpCheckLogEmail findByDepIdAndEmpId(Integer empByEmpId, Integer empByCheckEmpId);
	public void saveOrUpdateEmpCheckLogEmail(String empIdUser,String empIdArrayStr);
	public void removeEmpCheckLogEmailByEmpCheckLogEmailId(Integer empCheckLogEmailId);
	public void removeEmpCheckLogEmailByEmpCheckLogEmailIds(String empCheckLogEmailIds);
}
