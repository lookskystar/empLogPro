package com.emplog.bean;

/**
 * ReceiveLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ReceiveLog implements java.io.Serializable {

	// Fields

	private Integer receiveLogId;
	private LogMessage logMessage;
	private Emp emp;

	// Constructors

	/** default constructor */
	public ReceiveLog() {
	}

	/** full constructor */
	public ReceiveLog(LogMessage logMessage, Emp emp) {
		this.logMessage = logMessage;
		this.emp = emp;
	}

	// Property accessors

	public Integer getReceiveLogId() {
		return this.receiveLogId;
	}

	public void setReceiveLogId(Integer receiveLogId) {
		this.receiveLogId = receiveLogId;
	}

	public LogMessage getLogMessage() {
		return this.logMessage;
	}

	public void setLogMessage(LogMessage logMessage) {
		this.logMessage = logMessage;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}