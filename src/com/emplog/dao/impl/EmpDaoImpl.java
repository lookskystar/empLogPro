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
	
	/*分页 需要数据：1、数据总数。2、每页显示多少条数据。3、数据总数/每页显示多少条数据=页数。4、PageSize：每页显示多少条数据。
	 * TotalRow:数据总数。pageTotalRow：当前页总数据量。  page:当前页。
	 */
	
	/*分页
	 * 输入：pageTotalRow：当前页总数据量，page:当前页。
	 */
	
	public List<Emp> findPageByPageTotalRowAndPage(Integer pageTotalRow,Integer pageSize){
		//以下方法分页，在hql是不行的，hql不支持top,要使用sql
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select top"+" "+pageSize+" "+"*");
		sbSql.append(" "+"from emp");
		sbSql.append(" "+"where empId not in");
		sbSql.append("(select top "+pageTotalRow);
		sbSql.append(" "+"empId from emp ");
		sbSql.append(" "+"order by empId desc) order by empId desc");
	
		List<Emp> list=this.getSession().createSQLQuery(sbSql.toString()).addEntity("emp",Emp.class).list();

		return list;
		
			
//		//测试成功 经过测试，属于假分页
//		String hql = "from Emp";
//		Query query=this.getSession().createQuery(hql);
//		query.setFirstResult(4); //设置取记录位置
//		query.setMaxResults(2); //设置返回的对象数
//		List<Emp> list=query.list();
//		//测试
//		for (Emp emp:list) {
//			System.out.println("2----"+emp.getEmpName());
//		}
//		return list;
	}
	
	//返回总数
	public Integer findTotalRow(){
		  int count=0;          
          String hql = "select count(*) from Emp";
          count=((Long)this.getSession().createQuery(hql).uniqueResult()).intValue();
          return count;
	}
	
	
	
	
    /*
     * 员工登陆验证员工和密码
     */
	
	public List<Emp> findEmpByEmpNameAndEmpPassword(String empName, String empPassword) {
		String hql="from Emp emp where emp.empName='"+empName+"' and emp.empPassword='"+empPassword+"'";
		return this.getHibernateTemplate().find(hql);
	}	
}
