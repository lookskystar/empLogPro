package com.emplog.action.logMessage;

import java.util.Map;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListLogMessageByLogMessageEmpIdPagingAction extends ActionSupport {
	private LogMessage logMessage;
	private LogMessageService service;
	
	//��ҳ����
	private Integer page;     //��ǰҳ��
	private Integer pageTotalRow; //��ǰҳ������
	private Integer totalPage;  //��ҳ��
	private Integer pageSize;  //ÿҳ������
	private Integer totalRow;  //��������

	public LogMessageService getService() {
		return service;
	}

	public void setService(LogMessageService service) {
		this.service = service;
	}
	
	public LogMessage getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(LogMessage logMessage) {
		this.logMessage = logMessage;
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
		
		int pageSize=12;//ÿҳ������
		int page=1;//��ǰҳ��
		int totalPage=0;//��ҳ��
		
		int logMessageId=0;
		logMessageId=this.logMessage.getEmp().getEmpId();
		totalPage=this.service.findTotalPage(pageSize, logMessageId);
		Map request=(Map)ActionContext.getContext().get("request");
		
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
		request.put("list", this.service.findPageByPageTotalRowAndPage(this.page,pageSize,logMessageId));
		request.put("page", this.page);
		request.put("totalPage",totalPage);
		request.put("totalRow", this.service.findTotalRow(logMessageId));
		return SUCCESS;
	}
}
