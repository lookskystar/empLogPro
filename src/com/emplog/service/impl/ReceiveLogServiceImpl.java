package com.emplog.service.impl;

import java.util.List;

import com.emplog.bean.ReceiveLog;
import com.emplog.dao.ReceiveLogDao;
import com.emplog.service.ReceiveLogService;

public class ReceiveLogServiceImpl implements ReceiveLogService {
	private ReceiveLogDao receiveLogDao;
	

	public ReceiveLogDao getReceiveLogDao() {
		return receiveLogDao;
	}
	public void setReceiveLogDao(ReceiveLogDao receiveLogDao) {
		this.receiveLogDao = receiveLogDao;
	}


	
	public void saveReceiveLog(ReceiveLog leceiveLog) {
		this.receiveLogDao.saveReceiveLog(leceiveLog);
	}
	
	public List<ReceiveLog> findAllByLogMessageId(Integer logMessageId) {
		return this.receiveLogDao.findAllByLogMessageId(logMessageId);
	}

}
