package com.emplog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.emplog.bean.Dep;
import com.emplog.dao.DepDao;

public class DepDaoImpl extends HibernateDaoSupport implements DepDao {

	
	public void saveDep(Dep dep) {
		this.getHibernateTemplate().save(dep);
	}

	@SuppressWarnings("unchecked")
	public List<Dep> findAllDep() {
		String hql="from Dep dep order by dep.depId desc";
		return this.getHibernateTemplate().find(hql);
	}

	
	public Dep findDepByDepId(Integer depId) {
		Dep dep= (Dep)this.getHibernateTemplate().get(Dep.class, depId);
		return dep;
	}

	
	public void updateDep(Dep dep) {
		this.getHibernateTemplate().update(dep);
	}

	
	public void removeDep(Dep dep) {
		this.getHibernateTemplate().delete(dep);		
	}
}
