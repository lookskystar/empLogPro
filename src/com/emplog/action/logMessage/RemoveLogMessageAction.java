package com.emplog.action.logMessage;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionSupport;

public class RemoveLogMessageAction extends ActionSupport {
	private LogMessage logMessage;
	private LogMessageService service;
	
	private String logMessageIds;
	
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
	
	
	public String getLogMessageIds() {
		return logMessageIds;
	}
	public void setLogMessageIds(String logMessageIds) {
		this.logMessageIds = logMessageIds;
	}
	@Override
	public String execute() throws Exception {
		String logMessageIds=this.logMessageIds;
		
		if(logMessageIds==null){
			this.service.removeLogMessageById(this.logMessage.getLogMessageId().toString());
		}else{
			this.service.removeLogMessageById(logMessageIds);
		}
		return SUCCESS;
	}
}
