package com.emplog.service;

import java.util.List;

import com.emplog.bean.ReceiveLog;

public interface ReceiveLogService {
	public void saveReceiveLog(ReceiveLog leceiveLog);
	public List<ReceiveLog> findAllByLogMessageId(Integer logMessageId);
}
