package com.emplog.action.logMessage;


import java.util.Map;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListLogMessageByLogMessageEmpIdAction extends ActionSupport {

	private LogMessage logMessage;
	private LogMessageService service;

	public LogMessageService getService() {
		return service;
	}

	public void setService(LogMessageService service) {
		this.service = service;
	}
	
	public LogMessage getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(LogMessage logMessage) {
		this.logMessage = logMessage;
	}

	@Override
	public String execute() throws Exception {
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", this.service.findAllByLogMessageEmpId(this.logMessage.getEmp().getEmpId()));
		//request.put("list", this.service.findAllByLogMessageEmpId(4));
		return SUCCESS;
	}
	
}
