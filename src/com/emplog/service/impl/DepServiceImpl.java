package com.emplog.service.impl;

import java.util.List;

import com.emplog.bean.Dep;
import com.emplog.dao.DepDao;
import com.emplog.service.DepService;

public class DepServiceImpl implements DepService {

	private DepDao depDao;
	public DepDao getDepDao() {
		return depDao;
	}
	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}

	
	public List<Dep> findAllDep() {
		return this.depDao.findAllDep();
	}

	
	public Dep findDepByDepId(Integer depId) {
		return this.depDao.findDepByDepId(depId);
	}

	
	public void removeDep(Dep dep) {
		this.depDao.removeDep(dep);	
	}

	
	public void saveDep(Dep dep) {
		this.depDao.saveDep(dep);
	}

	
	public void updateDep(Dep dep) {
		this.depDao.updateDep(dep);
	}
	


}
