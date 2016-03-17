package com.emplog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.emplog.bean.Emp;
import com.emplog.dao.EmpDao;

public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {

	
	public void saveEmp(Emp emp) {
		this.getHibernateTemplate().save(emp);
	}

	
	public List<Emp> findAllEmp() {
		String hql="from Emp emp order by emp.empId desc";
		return this.getHibernateTemplate().find(hql);
	}

	
	public Emp findEmpByEmpId(Integer empId) {
		Emp emp=(Emp)this.getHibernateTemplate().get(Emp.class, empId);
		return emp;
	}

	
	public void removeEmp(Emp emp) {
		this.getHibernateTemplate().delete(emp);
	}

	
	public void updateEmp(Emp emp) {
		this.getHibernateTemplate().update(emp);
	}

	
	public List<Emp> findEmpsByDepId(Integer depId) {
		String hql="from Emp emp where emp.dep.depId="+depId+" order by emp.empId desc";
		return this.getHibernateTemplate().find(hql);
	}
	
	
	public List<Emp> findEmpsByEmpName(String empName) {
		String hql="from Emp emp where emp.empName='"+empName+"'";
		List<Emp> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	
	public void removeEmpById(Integer empId) {
		String hql="delete Emp emp where emp.empId="+empId;
		this.getSession().createQuery(hql).executeUpdate();

	}
	
	/*��ҳ ��Ҫ���ݣ�1������������2��ÿҳ��ʾ���������ݡ�3����������/ÿҳ��ʾ����������=ҳ����4��PageSize��ÿҳ��ʾ���������ݡ�
	 * TotalRow:����������pageTotalRow����ǰҳ����������  page:��ǰҳ��
	 */
	
	/*��ҳ
	 * ���룺pageTotalRow����ǰҳ����������page:��ǰҳ��
	 */
	
	public List<Emp> findPageByPageTotalRowAndPage(Integer pageTotalRow,Integer pageSize){
		//���·�����ҳ����hql�ǲ��еģ�hql��֧��top,Ҫʹ��sql
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select top"+" "+pageSize+" "+"*");
		sbSql.append(" "+"from emp");
		sbSql.append(" "+"where empId not in");
		sbSql.append("(select top "+pageTotalRow);
		sbSql.append(" "+"empId from emp ");
		sbSql.append(" "+"order by empId desc) order by empId desc");
	
		List<Emp> list=this.getSession().createSQLQuery(sbSql.toString()).addEntity("emp",Emp.class).list();

		return list;
		
			
//		//���Գɹ� �������ԣ����ڼٷ�ҳ
//		String hql = "from Emp";
//		Query query=this.getSession().createQuery(hql);
//		query.setFirstResult(4); //����ȡ��¼λ��
//		query.setMaxResults(2); //���÷��صĶ�����
//		List<Emp> list=query.list();
//		//����
//		for (Emp emp:list) {
//			System.out.println("2----"+emp.getEmpName());
//		}
//		return list;
	}
	
	//��������
	public Integer findTotalRow(){
		  int count=0;          
          String hql = "select count(*) from Emp";
          count=((Long)this.getSession().createQuery(hql).uniqueResult()).intValue();
          return count;
	}
	
	
	
	
    /*
     * Ա����½��֤Ա��������
     */
	
	public List<Emp> findEmpByEmpNameAndEmpPassword(String empName, String empPassword) {
		String hql="from Emp emp where emp.empName='"+empName+"' and emp.empPassword='"+empPassword+"'";
		return this.getHibernateTemplate().find(hql);
	}	
}
