package com.emplog.action.receiveLog;

import com.emplog.bean.ReceiveLog;
import com.emplog.service.ReceiveLogService;
import com.opensymphony.xwork2.ActionSupport;

public class SaveReceiveLogAction extends ActionSupport {
	private ReceiveLogService service;
	private ReceiveLog receiveLog;

	public ReceiveLogService getService() {
		return service;
	}
	public void setService(ReceiveLogService service) {
		this.service = service;
	}
	public ReceiveLog getReceiveLog() {
		return receiveLog;
	}
	public void setReceiveLog(ReceiveLog receiveLog) {
		this.receiveLog = receiveLog;
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
