package com.emplog.action.logMessage;

import java.util.Map;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 根据title模糊查询
 */
public class FindAllByLogMessageLikeTitleAction extends ActionSupport {
	private LogMessageService service;
	private LogMessage logMessage;
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
		request.put("list", this.service.findAllByLogMessageLikeTitle(this.logMessage.getEmp().getEmpId(),this.logMessage.getLogMessageTitle()));
		return SUCCESS;
	}
}
