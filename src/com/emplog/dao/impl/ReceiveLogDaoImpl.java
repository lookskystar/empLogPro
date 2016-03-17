package com.emplog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.emplog.bean.ReceiveLog;
import com.emplog.dao.ReceiveLogDao;

public class ReceiveLogDaoImpl extends HibernateDaoSupport implements ReceiveLogDao {

	
	public void saveReceiveLog(ReceiveLog leceiveLog) {
		this.getHibernateTemplate().save(leceiveLog);
	}

	
	public List<ReceiveLog> findAllByLogMessageId(Integer logMessageId) {
		String hql="from ReceiveLog receiveLog where receiveLog.logMessage.logMessageId="+logMessageId+" order by receiveLog.receiveLogId";
		return this.getHibernateTemplate().find(hql);
	}

	
	public void removeReceiveLogByLogMessageId(Integer logMessageId) {
		String hql="delete ReceiveLog receiveLog where receiveLog.logMessage.logMessageId="+logMessageId;
		this.getSession().createQuery(hql).executeUpdate();
	}	
}
