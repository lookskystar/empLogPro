package com.emplog.service.impl;

import java.util.List;

import com.emplog.bean.Emp;
import com.emplog.dao.EmpDao;
import com.emplog.service.EmpService;

public class EmpServiceImpl implements EmpService{
	
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	

	
	public List<Emp> findAllEmp() {
		List<Emp> list=this.empDao.findAllEmp();
		System.out.println("findAllEmp");
		return list;
	}

	
	public Emp findEmpByEmpId(Integer empId) {
		return this.empDao.findEmpByEmpId(empId);
	}

	
	public void removeEmp(Emp emp) {
		this.empDao.removeEmp(emp);
	}

	/*
	 * (non-Javadoc)
	 * @see com.emplog.service.EmpService#saveEmp(com.emplog.bean.Emp)
	 * 只保存，没有检查用户名是否存在
	 */
	
	public void saveEmp(Emp emp) {
		this.empDao.saveEmp(emp);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.emplog.service.EmpService#checkEmpNameSaveEmp(com.emplog.bean.Emp)
	 * 保存前，先检查用户名是否存在
	 */
	
	public boolean checkEmpNameSaveEmp(Emp emp) {
		//保存员工信息前，先要检查该员工用户名是否被使用过
		if(this.findEmpsByEmpName(emp.getEmpName())){
			return false;
		}else{
			this.empDao.saveEmp(emp);
			return true;
		}
		
	}

	
	public void updateEmp(Emp emp) {
		this.empDao.updateEmp(emp);
	}

	
	public List<Emp> findEmpsByDepId(Integer depId) {
		return this.empDao.findEmpsByDepId(depId);
	}
	
	
	public boolean findEmpsByEmpName(String empName) {
		
	    List<Emp> list=this.empDao.findEmpsByEmpName(empName);
	    if(list.size()==0){
	    	return false;
	    }else{
	    	return true;
	    }
	}

	
	public void removeEmpById(String empIds) {
		int empId=0;
		String[] empIdArry=empIds.split(",");
		for (int i = 0; i < empIdArry.length; i++) {
			empId=Integer.parseInt(empIdArry[i]);
			this.empDao.removeEmpById(empId);
		}
	}
	
	
	/*分页 需要数据：1、数据总数。2、每页显示多少条数据。3、数据总数/每页显示多少条数据=页数。4、PageSize：每页显示多少条数据。
	 * TotalRow:数据总数.
	 */
	
	/*分页
	 * 传入pageSize:页面大小，page：当前页数
	 */
	public List<Emp> findPageByPageTotalRowAndPage(int pageSize,int page){
		Integer pageTotalRow=this.findPageTotalRow(pageSize, page);
		return this.empDao.findPageByPageTotalRowAndPage(pageTotalRow, pageSize);
	}
	
	
	//通过page页数和页面大小，计算当前页总数量     pageTotalRow=page*pageSize
	//返回总数
	
	public Integer findTotalRow(){
		Integer c=this.empDao.findTotalRow();
		return c;
	}
	
	/*计算总页数
	 * 传入每页大小
	 */
	
	public Integer findTotalPage(Integer pageSize){
		Integer totalRow=this.findTotalRow(); //总数据
		Integer pages=0; //总页数
		//求模运算，如果总页数不是整数，则加1
		if(totalRow%pageSize==0){
			pages=totalRow/pageSize;
		}else{
			pages=totalRow/pageSize+1;
		}
		return pages;
	}
	
	
	/*当前页总数据量
	 * (non-Javadoc)传入：page：当前页。pageSize：页面大小
	 * @see com.emplog.service.EmpService#findPageTotalRow(java.lang.Integer, java.lang.Integer)
	 */
	
	public Integer findPageTotalRow(Integer pageSize,Integer page){
		Integer pageTotalRow=(page-1)*pageSize;
		return pageTotalRow;
	}


	/*
       员工登陆验证 
            把dao传的list值对象基本信息转换成实体对象，因为这个对象最终是要放到session中的 
	 */
	
	public Emp findEmpByEmpNameAndEmpPassword(String empName, String empPassword) {
		List<Emp> list=this.empDao.findEmpByEmpNameAndEmpPassword(empName, empPassword);
		Emp emp=null;
		
		if(list.size()>0){
			try {
				emp = (Emp) Class.forName("com.emplog.bean.Emp").newInstance();
				
				emp.setEmpId(list.get(0).getEmpId());
				emp.setDep(list.get(0).getDep());
				emp.setEmpName(list.get(0).getEmpName());
				emp.setEmpSex(list.get(0).getEmpSex());
				emp.setEmpJob(list.get(0).getEmpJob());
				emp.setEmpBirthday(list.get(0).getEmpBirthday());
				emp.setEmpTel(list.get(0).getEmpTel());
				emp.setEmpEmail(list.get(0).getEmpEmail());
				emp.setEmpAddress(list.get(0).getEmpAddress());
				emp.setEmpPassword(list.get(0).getEmpPassword());
				emp.setEmpRemark(list.get(0).getEmpRemark());
				
				//把实体对象放入session中
				
				return emp;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
}
