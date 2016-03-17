package com.emplog.service.impl;

import java.util.Date;
import java.util.List;

import com.emplog.bean.Emp;
import com.emplog.bean.EmpCheckLogEmail;
import com.emplog.bean.LogMessage;
import com.emplog.bean.ReceiveLog;
import com.emplog.dao.EmpCheckLogEmailDao;
import com.emplog.dao.LogMessageDao;
import com.emplog.dao.ReceiveLogDao;
import com.emplog.service.LogMessageService;

public class LogMessageServiceImpl implements LogMessageService {
	private LogMessageDao logMessageDao;
	private EmpCheckLogEmailDao empCheckLogEmailDao;
	private ReceiveLogDao receiveLogDao;

	public LogMessageDao getLogMessageDao() {
		return logMessageDao;
	}
	public void setLogMessageDao(LogMessageDao logMessageDao) {
		this.logMessageDao = logMessageDao;
	}
	public EmpCheckLogEmailDao getEmpCheckLogEmailDao() {
		return empCheckLogEmailDao;
	}
	public void setEmpCheckLogEmailDao(EmpCheckLogEmailDao empCheckLogEmailDao) {
		this.empCheckLogEmailDao = empCheckLogEmailDao;
	}
	public ReceiveLogDao getReceiveLogDao() {
		return receiveLogDao;
	}
	public void setReceiveLogDao(ReceiveLogDao receiveLogDao) {
		this.receiveLogDao = receiveLogDao;
	}
	
	
	
	public void saveLogMessage(LogMessage logMessage) {
		this.logMessageDao.saveLogMessage(logMessage);
		//1、根据empId查询EmpCheckLogEmail表，得到checkEmpId对象，所有接收邮件的人，
		//2、循环把logMessageId和checkEmpId保存到receiveLog表中
		List<EmpCheckLogEmail> list=this.empCheckLogEmailDao.findAllByEmpId(logMessage.getEmp().getEmpId());
		try {
			for (int i = 0; i < list.size(); i++) {
				ReceiveLog receiveLog=null;
				Emp emp=null;
				
				receiveLog = (ReceiveLog) Class.forName("com.emplog.bean.ReceiveLog").newInstance();
				emp = (Emp) Class.forName("com.emplog.bean.Emp").newInstance();
				
				emp.setEmpId(list.get(i).getEmpByCheckEmpId().getEmpId());
				
				receiveLog.setEmp(emp);
				receiveLog.setLogMessage(logMessage);
				//调用receiveLogDao的saveReceiveLog
				this.receiveLogDao.saveReceiveLog(receiveLog);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LogMessage> findAllByLogMessageEmpId(Integer empId) {
		return this.logMessageDao.findAllByLogMessageEmpId(empId);
	}
	
	public List<LogMessage> findAllLogMessage() {
		return this.logMessageDao.findAllLogMessage();
	}
	
	public void removeLogMessage(LogMessage logMessage) {
		this.logMessageDao.removeLogMessage(logMessage);
		
	}
	
	public void removeLogMessageById(String logMessageIds) {
		int logMessageId=0;
		String[] logMessageIdArry=logMessageIds.split(",");
		for (int i = 0; i < logMessageIdArry.length; i++) {
			logMessageId=Integer.parseInt(logMessageIdArry[i]);
			//System.out.println("logMessageId----->:"+logMessageId);
			this.receiveLogDao.removeReceiveLogByLogMessageId(logMessageId);
			this.logMessageDao.removeLogMessageById(logMessageId);
		}
	}
	/*
	 * (non-Javadoc)
	 * 分页开始
	 * @see com.emplog.service.LogMessageService#findPageByPageTotalRowAndPage(int, int, int)
	 */
	
	public List<LogMessage> findPageByPageTotalRowAndPage(int page,int pageSize,
			int logMessageEmpId) {
		Integer pageTotalRow=0;
		
		Integer totalRow=this.findTotalRow(logMessageEmpId); //总数据
		
		//System.out.println("page:"+page+"------pageSize:--"+pageSize+"----------");
		
		//如果传进来自定义数据数大于数据库总数据数，要判断
		if(pageSize>totalRow){
			//System.out.println("---pageSize>totalRow");
			pageSize=totalRow;
		}

		//System.out.println("---pageSize<totalRow");

		pageTotalRow=this.findPageTotalRow(page,pageSize);
		//System.out.println("----sverice---pageTotalRow--"+pageTotalRow);
		
		return this.logMessageDao.findPageByPageTotalRowAndPage(pageTotalRow, pageSize,logMessageEmpId);
	}
	
	public Integer findPageTotalRow(Integer page, Integer pageSize) {
		
		Integer pageTotalRow=(page-1)*pageSize;
//		System.out.println("--sverice当前页总数据---pageTotalRow-------:"+pageTotalRow);
//		System.out.println("----sverice每页数据量--pageSize------"+pageSize);
//		System.out.println("---sverice页数-page--------"+page);
		return pageTotalRow;
	}
	
	public Integer findTotalPage(Integer pageSize,Integer logMessageEmpId) {
		Integer totalRow=this.findTotalRow(logMessageEmpId); //总数据
		
		//如果传进来自定义数据数大于数据库总数据数，要判断
		if(pageSize>totalRow){
			pageSize=totalRow;
		}
		
//		System.out.println("--service--pagesize--"+pageSize);
		
		Integer pages=0; //总页数
		//求模运算，如果总页数不是整数，则加1
		if(totalRow%pageSize==0){
			pages=totalRow/pageSize;
		}else{
			pages=totalRow/pageSize+1;
		}
		
//		System.out.println("--service--pages--"+pages);
		
		return pages;
	}
	
	/*
	 * 返回logMessageEmpId的总页数
	 */
	public Integer findTotalRow(Integer logMessageEmpId) {
		Integer c=this.logMessageDao.findTotalRow(logMessageEmpId);
		return c;
	}
	//////////////////////////
	
	public LogMessage findByLogMessageId(Integer logMessageId) {
		List<LogMessage> list= this.logMessageDao.findByLogMessageId(logMessageId);
		LogMessage logMessage=null;
		Emp emp=null;
		
		try {
		    logMessage = (LogMessage) Class.forName("com.emplog.bean.LogMessage").newInstance();
		    emp = (Emp) Class.forName("com.emplog.bean.Emp").newInstance();
		    
		    logMessage.setLogMessageId(list.get(0).getLogMessageId());
		    logMessage.setLogMessageTitle(list.get(0).getLogMessageTitle());
		    logMessage.setLogMessageContent1(list.get(0).getLogMessageContent1());
		    logMessage.setLogMessageContent2(list.get(0).getLogMessageContent2());
		    logMessage.setLogMessageContent3(list.get(0).getLogMessageContent3());
		    logMessage.setLogMessageTime(list.get(0).getLogMessageTime());
		    logMessage.setLogMessagePlan(list.get(0).getLogMessagePlan());
		    logMessage.setLogMessageRemark(list.get(0).getLogMessageRemark());
		    
		    logMessage.setEmp(list.get(0).getEmp()); 
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return logMessage;
	}
	
	//调用ReceiveLogDao中的findAllByLogMessageId
	
	public List<ReceiveLog> findAllByLogMessageId(Integer logMessageId) {
		return this.receiveLogDao.findAllByLogMessageId(logMessageId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.emplog.service.LogMessageService#findAllByLogMessageLikeTitle(java.lang.String)
	 * 根据title模糊查询
	 */
	
	public List<LogMessage> findAllByLogMessageLikeTitle(Integer logMessageEmpId,String logMessageTitle) {
		return this.logMessageDao.findAllByLogMessageLikeTitle(logMessageEmpId,logMessageTitle);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.emplog.service.LogMessageService#findAllByLogMessageByStarTiemAndEndTime(java.util.Date, java.util.Date)
	 * 根据开始时间和结束时间查询
	 */
	
	public List<LogMessage> findAllByLogMessageByStarTiemAndEndTime(Integer logMessageEmpId,
			Date starTime, Date endTime) {
		//如果endTime在starTime之后就返回true
		if(endTime.after(starTime)){
			return this.logMessageDao.findAllByLogMessageByStarTiemAndEndTime(logMessageEmpId,starTime, endTime);
		}else{
			return null;
		}
	}
	
	
}
