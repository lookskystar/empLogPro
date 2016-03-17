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
	 * (non-Javadoc)empIdUser:发送人id，empIdArrayStr:接收人id字符串
	 * 操作EmpCheckLogEmail表，先全部删除该发送人员信息，再添加该发送人员信息
	 * 
	 * @see com.emplog.service.EmpCheckLogEmailService#saveEmpCheckLogEmail(java.lang.String,
	 *      java.lang.String)
	 */
	
	public void saveEmpCheckLogEmail(String empIdUser, String empIdArrayStr) {
		try {
			// Emp empByEmpIdSave = new Emp(); // 这里要通过注入的方式是想，不能new
			Emp empByEmpIdSave = null;

			empByEmpIdSave = (Emp) Class.forName("com.emplog.bean.Emp")
					.newInstance();

			int empIdUserInt = Integer.parseInt(empIdUser); // 发送人Id

			this.removeEmpCheckLogEmailByEmpId(empIdUserInt); // 删除该发送人员信息

			String[] empIdArray = empIdArrayStr.split(","); // 接收人id数组
			for (int i = 0; i < empIdArray.length; i++) {
				int empByCheckEmpIdInt = Integer.parseInt(empIdArray[i]);

				// EmpCheckLogEmail empCheckLogEmailSave = new
				// EmpCheckLogEmail(); // 这里要通过注入的方式是想，不能new
				EmpCheckLogEmail empCheckLogEmailSave = null;
				Emp empByCheckEmpIdsSave = null;
				empCheckLogEmailSave = (EmpCheckLogEmail) Class.forName(
						"com.emplog.bean.EmpCheckLogEmail").newInstance();
				// Emp empByCheckEmpIdsSave = new Emp(); // 这里要通过注入的方式是想，不能new
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
		// Emp empByEmpIdSaveOrUpdate = new Emp(); //这里要通过注入的方式是想，不能new
		Emp empByEmpIdSaveOrUpdate = null;
		try {
			empByEmpIdSaveOrUpdate = (Emp) Class.forName("com.emplog.bean.Emp")
					.newInstance();

			int empIdUserInt = Integer.parseInt(empIdUser); // 发送人Id

			// this.removeEmpCheckLogEmailByEmpId(empIdUserInt); //删除该发送人员信息

			String[] empIdArray = empIdArrayStr.split(","); // 接收人id数组
			for (int i = 0; i < empIdArray.length; i++) {
				int empByCheckEmpIdInt = Integer.parseInt(empIdArray[i]);

				// 根据empIdUserInt,
				// empByCheckEmpIdInt得到EmpCheckLogEmail，加到集合empCheckLogEmailList中
				// EmpCheckLogEmail empCheckLogEmailCheckSaveOrUpdate = new
				// EmpCheckLogEmail(); //这里要通过注入的方式是想，不能new
				EmpCheckLogEmail empCheckLogEmailCheckSaveOrUpdate = null;

				// 保存action传来的对象到实体bean empCheckLogEmail中
				// EmpCheckLogEmail empCheckLogEmailSaveOrUpdate = new
				// EmpCheckLogEmail(); //这里要通过注入的方式是想，不能new
				EmpCheckLogEmail empCheckLogEmailSaveOrUpdate = null;
				Emp empByCheckEmpId = null;

				empCheckLogEmailCheckSaveOrUpdate = (EmpCheckLogEmail) Class
						.forName("com.emplog.bean.EmpCheckLogEmail")
						.newInstance();
				empCheckLogEmailCheckSaveOrUpdate = this.findByDepIdAndEmpId(
						empIdUserInt, empByCheckEmpIdInt);
				// 用newInstance方法创建一个EmpCheckLogEmail对象empCheckLogEmailSaveOrUpdate
				empCheckLogEmailSaveOrUpdate = (EmpCheckLogEmail) Class
						.forName("com.emplog.bean.EmpCheckLogEmail")
						.newInstance();
				empByCheckEmpId = (Emp) Class.forName("com.emplog.bean.Emp")
						.newInstance();

				// Emp empByCheckEmpId = new Emp(); //这里要通过注入的方式是想，不能new

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
