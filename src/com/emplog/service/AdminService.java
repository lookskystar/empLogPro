package com.emplog.service;

import java.util.List;

import com.emplog.bean.Admin;

public interface AdminService {
	public void saveAdmin(Admin admin);
	public List<Admin> findAll();
	public void removeAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public Admin findAdminByAdminId(Integer adminId);
	public Admin findAdminByAdminNameAndAdminPassword(String adminName, String adminPassword);
}
