package com.emplog.dao;

import java.util.Date;
import java.util.List;


import com.emplog.bean.LogMessage;

public interface LogMessageDao {
	public void saveLogMessage(LogMessage logMessage);
	public List<LogMessage> findAllLogMessage();
	public List<LogMessage> findAllByLogMessageEmpId(Integer empId);
	public void removeLogMessage(LogMessage logMessage);
	public void removeLogMessageById(Integer logMessageId);
	public Integer findTotalRow(Integer logMessageEmpId);
	public List<LogMessage> findPageByPageTotalRowAndPage(Integer pageTotalRow,Integer pageSize,Integer logMessageEmpId);
	public List<LogMessage> findByLogMessageId(Integer logMessageId);
	public List<LogMessage> findAllByLogMessageLikeTitle(Integer logMessageEmpId,String logMessageTitle);
	
	public List<LogMessage> findAllByLogMessageByStarTiemAndEndTime(Integer logMessageEmpId,Date starTime,Date endTime);
}
