package com.emplog.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Dep entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Dep implements java.io.Serializable {

	// Fields

	private Integer depId;
	private String depName;
	private String depRemark;
	private Set emps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dep() {
	}

	/** full constructor */
	public Dep(String depName, String depRemark, Set emps) {
		this.depName = depName;
		this.depRemark = depRemark;
		this.emps = emps;
	}

	// Property accessors

	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepRemark() {
		return this.depRemark;
	}

	public void setDepRemark(String depRemark) {
		this.depRemark = depRemark;
	}

	public Set getEmps() {
		return this.emps;
	}

	public void setEmps(Set emps) {
		this.emps = emps;
	}

}