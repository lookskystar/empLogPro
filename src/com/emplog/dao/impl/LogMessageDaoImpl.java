package com.emplog.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.emplog.bean.LogMessage;
import com.emplog.dao.LogMessageDao;

public class LogMessageDaoImpl extends HibernateDaoSupport implements LogMessageDao  {

	
	public void saveLogMessage(LogMessage logMessage) {
		this.getHibernateTemplate().save(logMessage);
	}


	
	public List<LogMessage> findAllLogMessage() {
		String hql="from LogMessage logMessage order by logMessage.logMessageId desc";
		return this.getHibernateTemplate().find(hql);
	}
	
	
	public List<LogMessage> findAllByLogMessageEmpId(Integer empId) {
		String hql="from LogMessage logMessage where logMessage.emp.empId="+empId+" order by logMessage.logMessageId desc";
		return this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * @see com.emplog.dao.LogMessageDao#removeLogMessage(com.emplog.bean.LogMessage)
	 * 删除时候出现：
	 * org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1; nested exception is org.hibernate.StaleStateException:
	   乐观锁死锁问题无法解决，在日志列表中删除日志，停止使用该类
	 */
	
	public void removeLogMessage(LogMessage logMessage) {
		this.getHibernateTemplate().delete(logMessage);
	}

	
	public void removeLogMessageById(Integer logMessageId) {
		String hql="delete LogMessage logMessage where logMessage.logMessageId="+logMessageId;
		this.getSession().createQuery(hql).executeUpdate();
	}


	/*分页 需要数据：1、数据总数。2、每页显示多少条数据。3、数据总数/每页显示多少条数据=页数。4、PageSize：每页显示多少条数据。
	 * TotalRow:数据总数。pageTotalRow：当前页总数据量。  page:当前页。
	 */
	
	/*分页
	 * 输入：pageTotalRow：当前页总数据量，page:当前页。
	 */
	
	public List<LogMessage> findPageByPageTotalRowAndPage(Integer pageTotalRow,
			Integer pageSize,Integer logMessageEmpId) {
		//以下方法分页，在hql是不行的，hql不支持top,要使用sql
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select top"+" "+pageSize+" "+"*");
		sbSql.append(" "+"from logMessage");
		sbSql.append(" "+"where logMessageEmpId="+logMessageEmpId);
		sbSql.append(" "+"and logMessageId not in");
		sbSql.append("(select top "+pageTotalRow);
		sbSql.append(" "+"logMessageId from logMessage ");
		sbSql.append(" "+"order by logMessageId desc) order by logMessageId desc");
	
		List<LogMessage> list=this.getSession().createSQLQuery(sbSql.toString()).addEntity("logMessage",LogMessage.class).list();

		return list;
	}

	
	public Integer findTotalRow(Integer logMessageEmpId) {
		 int count=0;          
         String hql = "select count(*) from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId;
         count=((Long)this.getSession().createQuery(hql).uniqueResult()).intValue();
         return count;
	}

//////////////////////
	
	public List<LogMessage> findByLogMessageId(Integer logMessageId) {
		String hql="from LogMessage logMessage where logMessage.logMessageId="+logMessageId;
		return this.getHibernateTemplate().find(hql);
	}


	
	/*
	 * 根据title模糊查询
	 */
	public List<LogMessage> findAllByLogMessageLikeTitle(Integer logMessageEmpId,String logMessageTitle) {
		String hql="from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId+" and logMessage.logMessageTitle like'%"+logMessageTitle+"%'";
		return this.getHibernateTemplate().find(hql);
	}


	
	/*
	 * 根据开始时间和结束时间查询
	 */
	public List<LogMessage> findAllByLogMessageByStarTiemAndEndTime(Integer logMessageEmpId,
			Date starTime, Date endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		//String hql="from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId+" and (logMessage.logMessageTime>="+sdf.format(starTime)+" and logMessage.logMessageTime<="+sdf.format(endTime)+")";
		String hql="from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId+" and (logMessage.logMessageTime between '"+sdf.format(starTime)+"' and '"+sdf.format(endTime)+" 23:59:59.999')";
		return this.getHibernateTemplate().find(hql);
	}

}
