package com.emplog.action.emp;

import java.util.Map;

import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListEmpPagingAction extends ActionSupport {
	private EmpService service;
	
	//��ҳ����
	private Integer page;     //��ǰҳ��
	private Integer pageTotalRow; //��ǰҳ������
	private Integer totalPage;  //��ҳ��
	private Integer pageSize;  //ÿҳ������
	private Integer totalRow;  //��������
	

	public EmpService getService() {
		return service;
	}

	public void setService(EmpService service) {
		this.service = service;
	}
	
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getPageTotalRow() {
		return pageTotalRow;
	}

	public void setPageTotalRow(Integer pageTotalRow) {
		this.pageTotalRow = pageTotalRow;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

	public Integer getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}

	@Override
	public String execute() throws Exception {
		
		int pageSize=4;
		int page=1;
		int totalPage=0;
		
		totalPage=this.service.findTotalPage(pageSize);
		
		Map request=(Map)ActionContext.getContext().get("request");

		/*
		 * ���ԣ�
		 * 1��ÿҳ��ʾ4�����ݣ���һҳ   --   ���� 4,1   ok
	     * 2        4         2             4,2   ok
	     * 3        4         3             4,3   ok
		 */
		//��һ�ν����ʼ����û�е���һҳ����һҳ
		if(this.page==null){
			this.page=1;
		}
		//��֤�Ƿ����һҳ
		if(this.page>totalPage){
			this.page=totalPage;
			request.put("msg", "�Ѿ������һҳ��....");
		}
		//��֤�Ƿ��һҳ
		if(this.page<1){
			this.page=1;
			request.put("msg", "�����ǵ�һҳ....");
		}
		//����,pageSize:ҳ���С��page����ǰҳ��
		request.put("list", this.service.findPageByPageTotalRowAndPage(pageSize,this.page));
		request.put("page", this.page);
		request.put("totalPage",totalPage);
		request.put("totalRow", this.service.findTotalRow());

		return SUCCESS;
	}
}
