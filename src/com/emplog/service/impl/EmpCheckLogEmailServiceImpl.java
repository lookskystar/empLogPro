package com.emplog.service.impl;

import java.util.List;

import com.emplog.bean.Emp;
import com.emplog.bean.EmpCheckLogEmail;
import com.emplog.service.EmpCheckLogEmailService;
import com.emplog.dao.EmpCheckLogEmailDao;

;

public class EmpCheckLogEmailServiceImpl implements EmpCheckLogEmailService {
	private EmpCheckLogEmailDao empCheckLogEmailDao;

	// private Emp empByEmpIdSave;
	// private EmpCheckLogEmail empCheckLogEmailSave;
	// private Emp empByCheckEmpIdsSave;

	// private Emp empByEmpIdSaveOrUpdate;
	// private EmpCheckLogEmail empCheckLogEmailCheckSaveOrUpdate;
	// private EmpCheckLogEmail empCheckLogEmailSaveOrUpdate;

	public EmpCheckLogEmailDao getEmpCheckLogEmailDao() {
		return empCheckLogEmailDao;
	}

	public void setEmpCheckLogEmailDao(EmpCheckLogEmailDao empCheckLogEmailDao) {
		this.empCheckLogEmailDao = empCheckLogEmailDao;
	}

	// public Emp getEmpByEmpIdSave() {
	// return empByEmpIdSave;
	// }
	// public void setEmpByEmpIdSave(Emp empByEmpIdSave) {
	// this.empByEmpIdSave = empByEmpIdSave;
	// }
	//	
	// public EmpCheckLogEmail getEmpCheckLogEmailSave() {
	// return empCheckLogEmailSave;
	// }
	// public void setEmpCheckLogEmailSave(EmpCheckLogEmail
	// empCheckLogEmailSave) {
	// this.empCheckLogEmailSave = empCheckLogEmailSave;
	// }
	//	
	// public Emp getEmpByCheckEmpIdsSave() {
	// return empByCheckEmpIdsSave;
	// }
	// public void setEmpByCheckEmpIdsSave(Emp empByCheckEmpIdsSave) {
	// this.empByCheckEmpIdsSave = empByCheckEmpIdsSave;
	// }

	// public Emp getEmpByEmpIdSaveOrUpdate() {
	// return empByEmpIdSaveOrUpdate;
	// }
	// public void setEmpByEmpIdSaveOrUpdate(Emp empByEmpIdSaveOrUpdate) {
	// this.empByEmpIdSaveOrUpdate = empByEmpIdSaveOrUpdate;
	// }
	//	
	//	
	// public EmpCheckLogEmail getEmpCheckLogEmailCheckSaveOrUpdate() {
	// return empCheckLogEmailCheckSaveOrUpdate;
	// }
	// public void setEmpCheckLogEmailCheckSaveOrUpdate(
	// EmpCheckLogEmail empCheckLogEmailCheckSaveOrUpdate) {
	// this.empCheckLogEmailCheckSaveOrUpdate =
	// empCheckLogEmailCheckSaveOrUpdate;
	// }
	//	

	// public EmpCheckLogEmail getEmpCheckLogEmailSaveOrUpdate() {
	// return empCheckLogEmailSaveOrUpdate;
	// }
	// public void setEmpCheckLogEmailSaveOrUpdate(
	// EmpCheckLogEmail empCheckLogEmailSaveOrUpdate) {
	// this.empCheckLogEmailSaveOrUpdate = empCheckLogEmailSaveOrUpdate;
	// }

	
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
		try {
			// Emp empByEmpIdSave = new Emp(); // ����Ҫͨ��ע��ķ�ʽ���룬����new
			Emp empByEmpIdSave = null;

			empByEmpIdSave = (Emp) Class.forName("com.emplog.bean.Emp")
					.newInstance();

			int empIdUserInt = Integer.parseInt(empIdUser); // ������Id

			this.removeEmpCheckLogEmailByEmpId(empIdUserInt); // ɾ���÷�����Ա��Ϣ

			String[] empIdArray = empIdArrayStr.split(","); // ������id����
			for (int i = 0; i < empIdArray.length; i++) {
				int empByCheckEmpIdInt = Integer.parseInt(empIdArray[i]);

				// EmpCheckLogEmail empCheckLogEmailSave = new
				// EmpCheckLogEmail(); // ����Ҫͨ��ע��ķ�ʽ���룬����new
				EmpCheckLogEmail empCheckLogEmailSave = null;
				Emp empByCheckEmpIdsSave = null;
				empCheckLogEmailSave = (EmpCheckLogEmail) Class.forName(
						"com.emplog.bean.EmpCheckLogEmail").newInstance();
				// Emp empByCheckEmpIdsSave = new Emp(); // ����Ҫͨ��ע��ķ�ʽ���룬����new
				empByCheckEmpIdsSave = (Emp) Class.forName(
						"com.emplog.bean.Emp").newInstance();

				empByEmpIdSave.setEmpId(empIdUserInt);
				empByCheckEmpIdsSave.setEmpId(empByCheckEmpIdInt);

				empCheckLogEmailSave.setEmpByEmpId(empByEmpIdSave);
				empCheckLogEmailSave.setEmpByCheckEmpId(empByCheckEmpIdsSave);

				this.empCheckLogEmailDao
						.saveEmpCheckLogEmail(empCheckLogEmailSave);
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
		//EmpCheckLogEmail empCheckLogEmailFindByDepIdAndEmpId = new EmpCheckLogEmail();
		EmpCheckLogEmail empCheckLogEmailFindByDepIdAndEmpId =null;
		try {
			empCheckLogEmailFindByDepIdAndEmpId = (EmpCheckLogEmail) Class.forName("com.emplog.bean.EmpCheckLogEmail").newInstance();
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
		
		List<EmpCheckLogEmail> empCheckLogEmailList = this.empCheckLogEmailDao
				.findByDepIdAndEmpId(empByEmpId, empByCheckEmpId);
		if (empCheckLogEmailList.size() > 0) {
			int empCheckLogEmailId = empCheckLogEmailList.get(0)
					.getEmpCheckLogEmailId();

			Emp empIdObj = empCheckLogEmailList.get(0).getEmpByEmpId();
			Emp empByCheckEmpIdObj = empCheckLogEmailList.get(0)
					.getEmpByCheckEmpId();

			empCheckLogEmailFindByDepIdAndEmpId
					.setEmpCheckLogEmailId(empCheckLogEmailId);
			empCheckLogEmailFindByDepIdAndEmpId.setEmpByEmpId(empIdObj);
			empCheckLogEmailFindByDepIdAndEmpId
					.setEmpByCheckEmpId(empByCheckEmpIdObj);
		}
		return empCheckLogEmailFindByDepIdAndEmpId;
	}

	
	public void saveOrUpdateEmpCheckLogEmail(String empIdUser,
			String empIdArrayStr) {
		// Emp empByEmpIdSaveOrUpdate = new Emp(); //����Ҫͨ��ע��ķ�ʽ���룬����new
		Emp empByEmpIdSaveOrUpdate = null;
		try {
			empByEmpIdSaveOrUpdate = (Emp) Class.forName("com.emplog.bean.Emp")
					.newInstance();

			int empIdUserInt = Integer.parseInt(empIdUser); // ������Id

			// this.removeEmpCheckLogEmailByEmpId(empIdUserInt); //ɾ���÷�����Ա��Ϣ

			String[] empIdArray = empIdArrayStr.split(","); // ������id����
			for (int i = 0; i < empIdArray.length; i++) {
				int empByCheckEmpIdInt = Integer.parseInt(empIdArray[i]);

				// ����empIdUserInt,
				// empByCheckEmpIdInt�õ�EmpCheckLogEmail���ӵ�����empCheckLogEmailList��
				// EmpCheckLogEmail empCheckLogEmailCheckSaveOrUpdate = new
				// EmpCheckLogEmail(); //����Ҫͨ��ע��ķ�ʽ���룬����new
				EmpCheckLogEmail empCheckLogEmailCheckSaveOrUpdate = null;

				// ����action�����Ķ���ʵ��bean empCheckLogEmail��
				// EmpCheckLogEmail empCheckLogEmailSaveOrUpdate = new
				// EmpCheckLogEmail(); //����Ҫͨ��ע��ķ�ʽ���룬����new
				EmpCheckLogEmail empCheckLogEmailSaveOrUpdate = null;
				Emp empByCheckEmpId = null;

				empCheckLogEmailCheckSaveOrUpdate = (EmpCheckLogEmail) Class
						.forName("com.emplog.bean.EmpCheckLogEmail")
						.newInstance();
				empCheckLogEmailCheckSaveOrUpdate = this.findByDepIdAndEmpId(
						empIdUserInt, empByCheckEmpIdInt);
				// ��newInstance��������һ��EmpCheckLogEmail����empCheckLogEmailSaveOrUpdate
				empCheckLogEmailSaveOrUpdate = (EmpCheckLogEmail) Class
						.forName("com.emplog.bean.EmpCheckLogEmail")
						.newInstance();
				empByCheckEmpId = (Emp) Class.forName("com.emplog.bean.Emp")
						.newInstance();

				// Emp empByCheckEmpId = new Emp(); //����Ҫͨ��ע��ķ�ʽ���룬����new

				empByEmpIdSaveOrUpdate.setEmpId(empIdUserInt);
				empByCheckEmpId.setEmpId(empByCheckEmpIdInt);

				empCheckLogEmailSaveOrUpdate
						.setEmpByEmpId(empByEmpIdSaveOrUpdate);
				empCheckLogEmailSaveOrUpdate
						.setEmpByCheckEmpId(empByCheckEmpId);

				if (empCheckLogEmailCheckSaveOrUpdate.getEmpCheckLogEmailId() != null) {
					if (empCheckLogEmailCheckSaveOrUpdate.getEmpByEmpId()
							.getEmpId() == empIdUserInt
							&& empCheckLogEmailCheckSaveOrUpdate
									.getEmpByCheckEmpId().getEmpId() == empByCheckEmpIdInt) {
						empCheckLogEmailSaveOrUpdate
								.setEmpCheckLogEmailId(empCheckLogEmailCheckSaveOrUpdate
										.getEmpCheckLogEmailId());
						// this.empCheckLogEmailDao.updateEmpCheckLogEmail(empCheckLogEmail);
					}
				}
				// this.empCheckLogEmailDao.saveEmpCheckLogEmail(empCheckLogEmail);
				this.empCheckLogEmailDao
						.saveOrUpdateEmpCheckLogEmail(empCheckLogEmailSaveOrUpdate);
			}
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
