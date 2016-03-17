package com.emplog.dao;

import java.util.List;

import com.emplog.bean.Admin;
import com.emplog.bean.Emp;

public interface AdminDao {
	public void SaveAdmin(Admin admin);
	public List<Admin> findAllAdmin();
	public void removeAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public Admin findAdminByAdminId(Integer adminId);
	public List<Admin> findAdminByAdminNameAndAdminPassword(String adminName,
			String adminPassword);
}
