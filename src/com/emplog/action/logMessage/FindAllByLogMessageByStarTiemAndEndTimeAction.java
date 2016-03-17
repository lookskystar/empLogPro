package com.emplog.action.logMessage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllByLogMessageByStarTiemAndEndTimeAction extends ActionSupport {
	private LogMessageService service;
	private LogMessage logMessage;
	
	private Date starTime;
	private Date endTime;
	
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
	
	
	
	public Date getStarTime() {
		return starTime;
	}
	public void setStarTime(Date starTime) {
		this.starTime = starTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(this.starTime+":"+this.endTime);
		
		Map request=(Map)ActionContext.getContext().get("request");
		List<LogMessage> list=this.service.findAllByLogMessageByStarTiemAndEndTime(this.logMessage.getEmp().getEmpId(),this.starTime, this.endTime);
		if(list.size()!=0){
			request.put("list",list);
			return SUCCESS;
		}else{
			request.put("msg", "查无此数据！");
			return SUCCESS;
		}
		
	}
}
