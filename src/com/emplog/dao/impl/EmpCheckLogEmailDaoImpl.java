package com.emplog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.emplog.bean.EmpCheckLogEmail;
import com.emplog.dao.EmpCheckLogEmailDao;

public class EmpCheckLogEmailDaoImpl extends HibernateDaoSupport implements EmpCheckLogEmailDao {
	
	
	public List<EmpCheckLogEmail> findAllEmpCheckLogEmail() {
		String hql="from EmpCheckLogEmail empCheckLogEmail order by empCheckLogEmail.empCheckLogEmailId desc";
		return this.getHibernateTemplate().find(hql);
	}

	
	public void removeEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		this.getHibernateTemplate().delete(empCheckLogEmail);
		
	}

	
	public void saveEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		this.getHibernateTemplate().save(empCheckLogEmail);	
	}

	
	public void updateEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		this.getSession().clear();
		this.getHibernateTemplate().update(empCheckLogEmail);
		
	}

	
	public void removeEmpCheckLogEmailByEmpId(Integer empId) {
		String hql="delete EmpCheckLogEmail empCheckLogEmail where empCheckLogEmail.empByEmpId.empId="+empId;
		this.getSession().createQuery(hql).executeUpdate();
	}

	
	public List findAllByEmpId(Integer empId) {
//		StringBuffer sbSql=new StringBuffer();
//		sbSql.append("select ecle.checkEmpId, e.empName");
//		sbSql.append(" "+"from EmpCheckLogEmail as ecle,Emp as e");
//		sbSql.append(" "+"where e.empId=ecle.checkEmpId and ecle.empId="+empId);
//	
//		List<EmpCheckLogEmail> list=this.getSession().createSQLQuery(sbSql.toString()).addEntity("empCheckLogEmail",EmpCheckLogEmail.class).list();
//		System.out.println(list.size());
//		return list;
		
		String hql="from EmpCheckLogEmail empCheckLogEmail where empCheckLogEmail.empByEmpId.empId="+empId;	
		List list=this.getHibernateTemplate().find(hql);
		return list;
		
//		String hql="from EmpCheckLogEmail ecle,Emp e where ecle.empByCheckEmpId.empId=e.empId and ecle.empByEmpId.empId="+empId;	
//		List list=(List)this.getHibernateTemplate().find(hql);
//		return list;
	}

	
	public List<EmpCheckLogEmail> findByDepIdAndEmpId(Integer empByEmpId, Integer empByCheckEmpId) {
		String hql="from EmpCheckLogEmail empCheckLogEmail where empCheckLogEmail.empByEmpId.empId="+empByEmpId+"and empCheckLogEmail.empByCheckEmpId.empId="+empByCheckEmpId;	
		
		List<EmpCheckLogEmail> empCheckLogEmailList=this.getHibernateTemplate().find(hql);

		return empCheckLogEmailList;
	}

	
	public void saveOrUpdateEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		//this.getHibernateTemplate().saveOrUpdate(empCheckLogEmail);
		this.getSession().clear();
		this.getHibernateTemplate().saveOrUpdate(empCheckLogEmail);
		
		
	}

	
	public void removeEmpCheckLogEmailByEmpCheckLogEmailId(
			Integer empCheckLogEmailId) {
		String hql="delete EmpCheckLogEmail empCheckLogEmail where empCheckLogEmail.empCheckLogEmailId="+empCheckLogEmailId;
		this.getSession().createQuery(hql).executeUpdate();
		
	}

}
