package com.emplog.action.logMessage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindByLogMessageIdAction extends ActionSupport {
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

		//得到日志信息
		HttpServletRequest requestObj = ServletActionContext.getRequest();
		requestObj.setAttribute("requestObj", this.service.findByLogMessageId(this.logMessage.getLogMessageId()));
		
		//得到接收日志人的信息
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", this.service.findAllByLogMessageId(this.logMessage.getLogMessageId()));
		
		return SUCCESS;
	}
}
