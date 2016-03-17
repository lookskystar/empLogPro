package com.emplog.bean;

/**
 * Admin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String adminPassword;
	private Integer adminRole;
	private String adminRemark;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String adminName, String adminPassword, Integer adminRole) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminRole = adminRole;
	}

	/** full constructor */
	public Admin(String adminName, String adminPassword, Integer adminRole,
			String adminRemark) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminRole = adminRole;
		this.adminRemark = adminRemark;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getAdminRole() {
		return this.adminRole;
	}

	public void setAdminRole(Integer adminRole) {
		this.adminRole = adminRole;
	}

	public String getAdminRemark() {
		return this.adminRemark;
	}

	public void setAdminRemark(String adminRemark) {
		this.adminRemark = adminRemark;
	}

}