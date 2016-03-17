package com.emplog.service.impl;

import java.util.List;

import com.emplog.bean.Emp;
import com.emplog.bean.EmpCheckLogEmail;
import com.emplog.service.EmpCheckLogEmailService;
import com.emplog.dao.EmpCheckLogEmailDao;

;

public class CopyOfEmpCheckLogEmailServiceImplBAK implements EmpCheckLogEmailService {
	private EmpCheckLogEmailDao empCheckLogEmailDao;
	
	public EmpCheckLogEmailDao getEmpCheckLogEmailDao() {
		return empCheckLogEmailDao;
	}

	public void setEmpCheckLogEmailDao(EmpCheckLogEmailDao empCheckLogEmailDao) {
		this.empCheckLogEmailDao = empCheckLogEmailDao;
	}
	
	

	
	public List<EmpCheckLogEmail> findAllEmpCheckLogEmail() {
		return this.empCheckLogEmailDao.findAllEmpCheckLogEmail();
	}

	/*
	 * (non-Javadoc)empIdUser:������id��empIdArrayStr:������id�ַ���
	 * ����EmpCheckLogEmail����ȫ��ɾ���÷�����Ա��Ϣ������Ӹ÷�����Ա��Ϣ
	 * 
	 * @see com.emplog.service.EmpCheckLogEmailService#saveEmpCheckLogEmail(java.lang.String,
	 *      java.lang.String)
	 */
	
	public void saveEmpCheckLogEmail(String empIdUser, String empIdArrayStr) {
		Emp empByEmpId = new Emp();

		int empIdUserInt = Integer.parseInt(empIdUser); // ������Id

		this.removeEmpCheckLogEmailByEmpId(empIdUserInt); // ɾ���÷�����Ա��Ϣ

		String[] empIdArray = empIdArrayStr.split(","); // ������id����
		for (int i = 0; i < empIdArray.length; i++) {
			int empByCheckEmpIdInt = Integer.parseInt(empIdArray[i]);

			EmpCheckLogEmail empCheckLogEmail = new EmpCheckLogEmail();
			Emp empByCheckEmpId = new Emp();

			empByEmpId.setEmpId(empIdUserInt);
			empByCheckEmpId.setEmpId(empByCheckEmpIdInt);

			empCheckLogEmail.setEmpByEmpId(empByEmpId);
			empCheckLogEmail.setEmpByCheckEmpId(empByCheckEmpId);

			this.empCheckLogEmailDao.saveEmpCheckLogEmail(empCheckLogEmail);
		}
	}

	
	public void updateEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		this.empCheckLogEmailDao.updateEmpCheckLogEmail(empCheckLogEmail);
	}

	
	public void removeEmpCheckLogEmailByEmpId(Integer empId) {
		this.empCheckLogEmailDao.removeEmpCheckLogEmailByEmpId(empId);
	}

	
	public void removeEmpCheckLogEmail(EmpCheckLogEmail empCheckLogEmail) {
		this.empCheckLogEmailDao.removeEmpCheckLogEmail(empCheckLogEmail);
	}

	
	public List<EmpCheckLogEmail> findAllByEmpId(Integer empId) {
		return this.empCheckLogEmailDao.findAllByEmpId(empId);
	}

	
	public EmpCheckLogEmail findByDepIdAndEmpId(Integer empByEmpId,
			Integer empByCheckEmpId) {
		EmpCheckLogEmail empCheckLogEmail = new EmpCheckLogEmail();
		List<EmpCheckLogEmail> empCheckLogEmailList = this.empCheckLogEmailDao
				.findByDepIdAndEmpId(empByEmpId, empByCheckEmpId);
		if (empCheckLogEmailList.size() > 0) {
			int empCheckLogEmailId = empCheckLogEmailList.get(0)
					.getEmpCheckLogEmailId();

			Emp empIdObj = empCheckLogEmailList.get(0).getEmpByEmpId();
			Emp empByCheckEmpIdObj = empCheckLogEmailList.get(0)
					.getEmpByCheckEmpId();

			empCheckLogEmail.setEmpCheckLogEmailId(empCheckLogEmailId);
			empCheckLogEmail.setEmpByEmpId(empIdObj);
			empCheckLogEmail.setEmpByCheckEmpId(empByCheckEmpIdObj);
		}
		return empCheckLogEmail;
	}

	
	public void saveOrUpdateEmpCheckLogEmail(String empIdUser,
			String empIdArrayStr) {
		Emp empByEmpId = new Emp();

		int empIdUserInt = Integer.parseInt(empIdUser); // ������Id

		// this.removeEmpCheckLogEmailByEmpId(empIdUserInt); //ɾ���÷�����Ա��Ϣ

		String[] empIdArray = empIdArrayStr.split(","); // ������id����
		for (int i = 0; i < empIdArray.length; i++) {
			int empByCheckEmpIdInt = Integer.parseInt(empIdArray[i]);

			// ����empIdUserInt,
			// empByCheckEmpIdInt�õ�EmpCheckLogEmail���ӵ�����empCheckLogEmailList��
			EmpCheckLogEmail empCheckLogEmailCheck = new EmpCheckLogEmail();

			empCheckLogEmailCheck = this.findByDepIdAndEmpId(empIdUserInt,
					empByCheckEmpIdInt);

			// ����action�����Ķ���ʵ��bean empCheckLogEmail��
			EmpCheckLogEmail empCheckLogEmail = new EmpCheckLogEmail();
			Emp empByCheckEmpId = new Emp();

			empByEmpId.setEmpId(empIdUserInt);
			empByCheckEmpId.setEmpId(empByCheckEmpIdInt);

			empCheckLogEmail.setEmpByEmpId(empByEmpId);
			empCheckLogEmail.setEmpByCheckEmpId(empByCheckEmpId);

			if (empCheckLogEmailCheck.getEmpCheckLogEmailId() != null) {
				if (empCheckLogEmailCheck.getEmpByEmpId().getEmpId() == empIdUserInt
						&& empCheckLogEmailCheck.getEmpByCheckEmpId()
								.getEmpId() == empByCheckEmpIdInt) {
					empCheckLogEmail
							.setEmpCheckLogEmailId(empCheckLogEmailCheck
									.getEmpCheckLogEmailId());
					// this.empCheckLogEmailDao.updateEmpCheckLogEmail(empCheckLogEmail);
				}
			}
			// this.empCheckLogEmailDao.saveEmpCheckLogEmail(empCheckLogEmail);
			this.empCheckLogEmailDao
					.saveOrUpdateEmpCheckLogEmail(empCheckLogEmail);
		}
	}

	
	public void removeEmpCheckLogEmailByEmpCheckLogEmailId(
			Integer empCheckLogEmailId) {
		this.empCheckLogEmailDao
				.removeEmpCheckLogEmailByEmpCheckLogEmailId(empCheckLogEmailId);
	}

	
	public void removeEmpCheckLogEmailByEmpCheckLogEmailIds(
			String empCheckLogEmailIds) {
		int empCheckLogEmailId = 0;
		String[] empCheckLogEmailIdArry = empCheckLogEmailIds.split(",");
		for (int i = 0; i < empCheckLogEmailIdArry.length; i++) {
			empCheckLogEmailId = Integer.parseInt(empCheckLogEmailIdArry[i]);
			this.removeEmpCheckLogEmailByEmpCheckLogEmailId(empCheckLogEmailId);
		}
	}
}
