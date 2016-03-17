package com.emplog.service;

import java.util.Date;
import java.util.List;

import com.emplog.bean.LogMessage;
import com.emplog.bean.ReceiveLog;

public interface LogMessageService {
	public void saveLogMessage(LogMessage logMessage);
	public List<LogMessage> findAllLogMessage();
	public List<LogMessage> findAllByLogMessageEmpId(Integer empId);
	public void removeLogMessage(LogMessage logMessage);
	public void removeLogMessageById(String logMessageIds);
	public Integer findTotalRow(Integer logMessageEmpId);
	public Integer findTotalPage(Integer pageSize,Integer logMessageEmpId);
	public Integer findPageTotalRow(Integer page,Integer pageSize);
	public List<LogMessage> findPageByPageTotalRowAndPage(int pageSize,int page,int logMessageEmpId);
	public LogMessage findByLogMessageId(Integer logMessageId);
	public List<ReceiveLog> findAllByLogMessageId(Integer logMessageId);
	public List<LogMessage> findAllByLogMessageLikeTitle(Integer logMessageEmpId,String logMessageTitle);
	
	public List<LogMessage> findAllByLogMessageByStarTiemAndEndTime(Integer logMessageEmpId,Date starTime,Date endTime);
	
}
