package com.emplog.action.logMessage;


import java.util.Date;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionSupport;

public class SaveLogMessageAction extends ActionSupport {
	
	private LogMessage logMessage;
	private LogMessageService service;
	
	public LogMessage getLogMessage() {
		return logMessage;
	}
	public void setLogMessage(LogMessage logMessage) {
		this.logMessage = logMessage;
	}
	
	public LogMessageService getService() {
		return service;
	}
	public void setService(LogMessageService service) {
		this.service = service;
	}
	

	
	@Override
	public String execute() throws Exception {
		//System.out.println("======");
		//System.out.println(this.logMessage.getEmp().getEmpId());
	  this.logMessage.setLogMessageTime(new Date());
	  if(this.logMessage.getEmp().getEmpId()==null||"".equals(this.logMessage.getEmp().getEmpId())||this.logMessage.getEmp().getEmpId()==0){
		  return ERROR;
	  }
	  this.service.saveLogMessage(logMessage);
	  return SUCCESS;
	}


	
}
