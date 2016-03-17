package com.emplog.dao;

import java.util.List;

import com.emplog.bean.Dep;



public interface DepDao {
	public void saveDep(Dep dep);
	public List<Dep> findAllDep();
	public void removeDep(Dep dep);
	public void updateDep(Dep dep);
	public Dep findDepByDepId(Integer depId);
}
