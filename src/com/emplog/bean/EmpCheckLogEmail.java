package com.emplog.bean;

/**
 * EmpCheckLogEmail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class EmpCheckLogEmail implements java.io.Serializable {

	// Fields

	private Integer empCheckLogEmailId;
	private Emp empByEmpId;
	private Emp empByCheckEmpId;
	private String empCheckLogEmailRemark;

	// Constructors

	/** default constructor */
	public EmpCheckLogEmail() {
	}

	/** minimal constructor */
	public EmpCheckLogEmail(Emp empByEmpId, Emp empByCheckEmpId) {
		this.empByEmpId = empByEmpId;
		this.empByCheckEmpId = empByCheckEmpId;
	}

	/** full constructor */
	public EmpCheckLogEmail(Emp empByEmpId, Emp empByCheckEmpId,
			String empCheckLogEmailRemark) {
		this.empByEmpId = empByEmpId;
		this.empByCheckEmpId = empByCheckEmpId;
		this.empCheckLogEmailRemark = empCheckLogEmailRemark;
	}

	// Property accessors

	public Integer getEmpCheckLogEmailId() {
		return this.empCheckLogEmailId;
	}

	public void setEmpCheckLogEmailId(Integer empCheckLogEmailId) {
		this.empCheckLogEmailId = empCheckLogEmailId;
	}

	public Emp getEmpByEmpId() {
		return this.empByEmpId;
	}

	public void setEmpByEmpId(Emp empByEmpId) {
		this.empByEmpId = empByEmpId;
	}

	public Emp getEmpByCheckEmpId() {
		return this.empByCheckEmpId;
	}

	public void setEmpByCheckEmpId(Emp empByCheckEmpId) {
		this.empByCheckEmpId = empByCheckEmpId;
	}

	public String getEmpCheckLogEmailRemark() {
		return this.empCheckLogEmailRemark;
	}

	public void setEmpCheckLogEmailRemark(String empCheckLogEmailRemark) {
		this.empCheckLogEmailRemark = empCheckLogEmailRemark;
	}

}