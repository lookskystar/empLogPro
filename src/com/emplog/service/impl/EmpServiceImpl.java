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
	 * ֻ���棬û�м���û����Ƿ����
	 */
	
	public void saveEmp(Emp emp) {
		this.empDao.saveEmp(emp);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.emplog.service.EmpService#checkEmpNameSaveEmp(com.emplog.bean.Emp)
	 * ����ǰ���ȼ���û����Ƿ����
	 */
	
	public boolean checkEmpNameSaveEmp(Emp emp) {
		//����Ա����Ϣǰ����Ҫ����Ա���û����Ƿ�ʹ�ù�
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
	
	
	/*��ҳ ��Ҫ���ݣ�1������������2��ÿҳ��ʾ���������ݡ�3����������/ÿҳ��ʾ����������=ҳ����4��PageSize��ÿҳ��ʾ���������ݡ�
	 * TotalRow:��������.
	 */
	
	/*��ҳ
	 * ����pageSize:ҳ���С��page����ǰҳ��
	 */
	public List<Emp> findPageByPageTotalRowAndPage(int pageSize,int page){
		Integer pageTotalRow=this.findPageTotalRow(pageSize, page);
		return this.empDao.findPageByPageTotalRowAndPage(pageTotalRow, pageSize);
	}
	
	
	//ͨ��pageҳ����ҳ���С�����㵱ǰҳ������     pageTotalRow=page*pageSize
	//��������
	
	public Integer findTotalRow(){
		Integer c=this.empDao.findTotalRow();
		return c;
	}
	
	/*������ҳ��
	 * ����ÿҳ��С
	 */
	
	public Integer findTotalPage(Integer pageSize){
		Integer totalRow=this.findTotalRow(); //������
		Integer pages=0; //��ҳ��
		//��ģ���㣬�����ҳ���������������1
		if(totalRow%pageSize==0){
			pages=totalRow/pageSize;
		}else{
			pages=totalRow/pageSize+1;
		}
		return pages;
	}
	
	
	/*��ǰҳ��������
	 * (non-Javadoc)���룺page����ǰҳ��pageSize��ҳ���С
	 * @see com.emplog.service.EmpService#findPageTotalRow(java.lang.Integer, java.lang.Integer)
	 */
	
	public Integer findPageTotalRow(Integer pageSize,Integer page){
		Integer pageTotalRow=(page-1)*pageSize;
		return pageTotalRow;
	}


	/*
       Ա����½��֤ 
            ��dao����listֵ���������Ϣת����ʵ�������Ϊ�������������Ҫ�ŵ�session�е� 
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
				
				//��ʵ��������session��
				
				return emp;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
}
