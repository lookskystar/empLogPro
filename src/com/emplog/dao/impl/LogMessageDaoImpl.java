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
	 * ɾ��ʱ����֣�
	 * org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1; nested exception is org.hibernate.StaleStateException:
	   �ֹ������������޷����������־�б���ɾ����־��ֹͣʹ�ø���
	 */
	
	public void removeLogMessage(LogMessage logMessage) {
		this.getHibernateTemplate().delete(logMessage);
	}

	
	public void removeLogMessageById(Integer logMessageId) {
		String hql="delete LogMessage logMessage where logMessage.logMessageId="+logMessageId;
		this.getSession().createQuery(hql).executeUpdate();
	}


	/*��ҳ ��Ҫ���ݣ�1������������2��ÿҳ��ʾ���������ݡ�3����������/ÿҳ��ʾ����������=ҳ����4��PageSize��ÿҳ��ʾ���������ݡ�
	 * TotalRow:����������pageTotalRow����ǰҳ����������  page:��ǰҳ��
	 */
	
	/*��ҳ
	 * ���룺pageTotalRow����ǰҳ����������page:��ǰҳ��
	 */
	
	public List<LogMessage> findPageByPageTotalRowAndPage(Integer pageTotalRow,
			Integer pageSize,Integer logMessageEmpId) {
		//���·�����ҳ����hql�ǲ��еģ�hql��֧��top,Ҫʹ��sql
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
	 * ����titleģ����ѯ
	 */
	public List<LogMessage> findAllByLogMessageLikeTitle(Integer logMessageEmpId,String logMessageTitle) {
		String hql="from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId+" and logMessage.logMessageTitle like'%"+logMessageTitle+"%'";
		return this.getHibernateTemplate().find(hql);
	}


	
	/*
	 * ���ݿ�ʼʱ��ͽ���ʱ���ѯ
	 */
	public List<LogMessage> findAllByLogMessageByStarTiemAndEndTime(Integer logMessageEmpId,
			Date starTime, Date endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		//String hql="from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId+" and (logMessage.logMessageTime>="+sdf.format(starTime)+" and logMessage.logMessageTime<="+sdf.format(endTime)+")";
		String hql="from LogMessage logMessage where logMessage.emp.empId="+logMessageEmpId+" and (logMessage.logMessageTime between '"+sdf.format(starTime)+"' and '"+sdf.format(endTime)+" 23:59:59.999')";
		return this.getHibernateTemplate().find(hql);
	}

}
