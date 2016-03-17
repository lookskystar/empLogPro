package com.emplog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.emplog.bean.Admin;
import com.emplog.bean.Emp;
import com.emplog.dao.AdminDao;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {


	public void SaveAdmin(Admin admin) {
		//保存Admin对象(最后一步操作)
		
		System.out.println(admin.getAdminId());
		this.getHibernateTemplate().save(admin);
	}

	@SuppressWarnings("unchecked")
	public List<Admin> findAllAdmin() {
		String hql="from Admin admin order by admin.adminId desc";
		return this.getHibernateTemplate().find(hql);
	}


	public void removeAdmin(Admin admin) {
		this.getHibernateTemplate().delete(admin);
	}

	
	public void updateAdmin(Admin admin) {
		this.getHibernateTemplate().update(admin);
		
	}

	
	public Admin findAdminByAdminId(Integer adminId) {
		System.out.println("--1--："+adminId);
		Admin admin= (Admin)this.getHibernateTemplate().get(Admin.class, adminId);
		return admin;
		
	}

	public List<Admin> findAdminByAdminNameAndAdminPassword(String adminName,
			String adminPassword) {
		String hql="from Admin admin where admin.adminName='"+adminName+"' and admin.adminPassword='"+adminPassword+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
}
