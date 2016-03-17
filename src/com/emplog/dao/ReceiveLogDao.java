package com.emplog.dao;

import java.util.List;

import com.emplog.bean.ReceiveLog;;

public interface ReceiveLogDao {
	public void saveReceiveLog(ReceiveLog leceiveLog);
	public List<ReceiveLog> findAllByLogMessageId(Integer logMessageId);
	public void removeReceiveLogByLogMessageId(Integer logMessageId);
}
