package com.emplog.action.logMessage;

import java.util.Map;

import com.emplog.bean.LogMessage;
import com.emplog.service.LogMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListLogMessageByLogMessageEmpIdPagingAction extends ActionSupport {
	private LogMessage logMessage;
	private LogMessageService service;
	
	//分页属性
	private Integer page;     //当前页数
	private Integer pageTotalRow; //当前页总数据
	private Integer totalPage;  //总页数
	private Integer pageSize;  //每页数据量
	private Integer totalRow;  //总数据量

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
		
		int pageSize=12;//每页数据量
		int page=1;//当前页数
		int totalPage=0;//总页数
		
		int logMessageId=0;
		logMessageId=this.logMessage.getEmp().getEmpId();
		totalPage=this.service.findTotalPage(pageSize, logMessageId);
		Map request=(Map)ActionContext.getContext().get("request");
		
		if(this.page==null){
			this.page=1;
		}
		//验证是否最后一页
		if(this.page>totalPage){
			this.page=totalPage;
			request.put("msg", "已经到最后一页了....");
		}
		//验证是否第一页
		if(this.page<1){
			this.page=1;
			request.put("msg", "这里是第一页....");
		}
		//传入,pageSize:页面大小，page：当前页数
		request.put("list", this.service.findPageByPageTotalRowAndPage(this.page,pageSize,logMessageId));
		request.put("page", this.page);
		request.put("totalPage",totalPage);
		request.put("totalRow", this.service.findTotalRow(logMessageId));
		return SUCCESS;
	}
}
