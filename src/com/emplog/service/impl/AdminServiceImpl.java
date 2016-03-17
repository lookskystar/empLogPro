package com.emplog.service.impl;

import java.util.List;

import com.emplog.bean.Admin;
import com.emplog.bean.Emp;
import com.emplog.dao.AdminDao;
import com.emplog.service.AdminService;

//���￪ʼ����springע����
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	
	public void saveAdmin(Admin admin) {
		this.adminDao.SaveAdmin(admin); //��������� ҵ���߼�
	}

	
	public List<Admin> findAll() {
		return this.adminDao.findAllAdmin();
	}

	
	public void removeAdmin(Admin admin) {
		this.adminDao.removeAdmin(admin);
		
	}
	
	
	
	public Admin findAdminByAdminId(Integer adminId) {
		//System.out.println("--2--"+adminId);
		Admin admin=this.adminDao.findAdminByAdminId(adminId);
		System.out.println("--3--:"+admin.getAdminName());
		return admin;
	}

	
	public void updateAdmin(Admin admin) {
		this.adminDao.updateAdmin(admin);
	}

	public Admin findAdminByAdminNameAndAdminPassword(String adminName,
			String adminPassword) {
		List<Admin> list=(List<Admin>) this.adminDao.findAdminByAdminNameAndAdminPassword(adminName, adminPassword);
		Admin admin=null;
		
		if(list.size()>0){
			try {
				admin = (Admin) Class.forName("com.emplog.bean.Admin").newInstance();
				admin.setAdminId(list.get(0).getAdminId());
				admin.setAdminName(list.get(0).getAdminName());
				admin.setAdminPassword(list.get(0).getAdminPassword());
				admin.setAdminRole(list.get(0).getAdminRole());
				admin.setAdminRemark(list.get(0).getAdminRemark());
				
				//��ʵ��������session��
				
				return admin;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			return admin;
	}
}

