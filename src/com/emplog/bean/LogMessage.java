package com.emplog.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LogMessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class LogMessage implements java.io.Serializable {

	// Fields

	private Integer logMessageId;
	private Emp emp;
	private String logMessageTitle;
	private String logMessageContent1;
	private String logMessageContent2;
	private String logMessageContent3;
	private Date logMessageTime;
	private Integer logMessagePlan;
	private String logMessageRemark;
	private Set receiveLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public LogMessage() {
	}

	/** full constructor */
	public LogMessage(Emp emp, String logMessageTitle,
			String logMessageContent1, String logMessageContent2,
			String logMessageContent3, Date logMessageTime,
			Integer logMessagePlan, String logMessageRemark, Set receiveLogs) {
		this.emp = emp;
		this.logMessageTitle = logMessageTitle;
		this.logMessageContent1 = logMessageContent1;
		this.logMessageContent2 = logMessageContent2;
		this.logMessageContent3 = logMessageContent3;
		this.logMessageTime = logMessageTime;
		this.logMessagePlan = logMessagePlan;
		this.logMessageRemark = logMessageRemark;
		this.receiveLogs = receiveLogs;
	}

	// Property accessors

	public Integer getLogMessageId() {
		return this.logMessageId;
	}

	public void setLogMessageId(Integer logMessageId) {
		this.logMessageId = logMessageId;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getLogMessageTitle() {
		return this.logMessageTitle;
	}

	public void setLogMessageTitle(String logMessageTitle) {
		this.logMessageTitle = logMessageTitle;
	}

	public String getLogMessageContent1() {
		return this.logMessageContent1;
	}

	public void setLogMessageContent1(String logMessageContent1) {
		this.logMessageContent1 = logMessageContent1;
	}

	public String getLogMessageContent2() {
		return this.logMessageContent2;
	}

	public void setLogMessageContent2(String logMessageContent2) {
		this.logMessageContent2 = logMessageContent2;
	}

	public String getLogMessageContent3() {
		return this.logMessageContent3;
	}

	public void setLogMessageContent3(String logMessageContent3) {
		this.logMessageContent3 = logMessageContent3;
	}

	public Date getLogMessageTime() {
		return this.logMessageTime;
	}

	public void setLogMessageTime(Date logMessageTime) {
		this.logMessageTime = logMessageTime;
	}

	public Integer getLogMessagePlan() {
		return this.logMessagePlan;
	}

	public void setLogMessagePlan(Integer logMessagePlan) {
		this.logMessagePlan = logMessagePlan;
	}

	public String getLogMessageRemark() {
		return this.logMessageRemark;
	}

	public void setLogMessageRemark(String logMessageRemark) {
		this.logMessageRemark = logMessageRemark;
	}

	public Set getReceiveLogs() {
		return this.receiveLogs;
	}

	public void setReceiveLogs(Set receiveLogs) {
		this.receiveLogs = receiveLogs;
	}

}