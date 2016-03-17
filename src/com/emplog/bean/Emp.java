package com.emplog.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Emp entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer empId;
	private Dep dep;
	private String empJob;
	private String empName;
	private Integer empSex;
	private Date empBirthday;
	private String empTel;
	private String empEmail;
	private String empAddress;
	private String empPassword;
	private String empRemark;
	private Set logMessages = new HashSet(0);
	private Set empCheckLogEmailsForEmpId = new HashSet(0);
	private Set empCheckLogEmailsForCheckEmpId = new HashSet(0);
	private Set receiveLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(Dep dep, String empName, Integer empSex, Date empBirthday,
			String empEmail, String empPassword) {
		this.dep = dep;
		this.empName = empName;
		this.empSex = empSex;
		this.empBirthday = empBirthday;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
	}

	/** full constructor */
	public Emp(Dep dep, String empJob, String empName, Integer empSex,
			Date empBirthday, String empTel, String empEmail,
			String empAddress, String empPassword, String empRemark,
			Set logMessages, Set empCheckLogEmailsForEmpId,
			Set empCheckLogEmailsForCheckEmpId, Set receiveLogs) {
		this.dep = dep;
		this.empJob = empJob;
		this.empName = empName;
		this.empSex = empSex;
		this.empBirthday = empBirthday;
		this.empTel = empTel;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
		this.empPassword = empPassword;
		this.empRemark = empRemark;
		this.logMessages = logMessages;
		this.empCheckLogEmailsForEmpId = empCheckLogEmailsForEmpId;
		this.empCheckLogEmailsForCheckEmpId = empCheckLogEmailsForCheckEmpId;
		this.receiveLogs = receiveLogs;
	}

	// Property accessors

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Dep getDep() {
		return this.dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public String getEmpJob() {
		return this.empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}

	public Date getEmpBirthday() {
		return this.empBirthday;
	}

	public void setEmpBirthday(Date empBirthday) {
		this.empBirthday = empBirthday;
	}

	public String getEmpTel() {
		return this.empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpRemark() {
		return this.empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	public Set getLogMessages() {
		return this.logMessages;
	}

	public void setLogMessages(Set logMessages) {
		this.logMessages = logMessages;
	}

	public Set getEmpCheckLogEmailsForEmpId() {
		return this.empCheckLogEmailsForEmpId;
	}

	public void setEmpCheckLogEmailsForEmpId(Set empCheckLogEmailsForEmpId) {
		this.empCheckLogEmailsForEmpId = empCheckLogEmailsForEmpId;
	}

	public Set getEmpCheckLogEmailsForCheckEmpId() {
		return this.empCheckLogEmailsForCheckEmpId;
	}

	public void setEmpCheckLogEmailsForCheckEmpId(
			Set empCheckLogEmailsForCheckEmpId) {
		this.empCheckLogEmailsForCheckEmpId = empCheckLogEmailsForCheckEmpId;
	}

	public Set getReceiveLogs() {
		return this.receiveLogs;
	}

	public void setReceiveLogs(Set receiveLogs) {
		this.receiveLogs = receiveLogs;
	}

}