package com.emplog.action.emp;

import java.util.Map;

import com.emplog.service.EmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListEmpPagingAction extends ActionSupport {
	private EmpService service;
	
	//分页属性
	private Integer page;     //当前页数
	private Integer pageTotalRow; //当前页总数据
	private Integer totalPage;  //总页数
	private Integer pageSize;  //每页数据量
	private Integer totalRow;  //总数据量
	

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
		 * 测试：
		 * 1、每页显示4条数据，第一页   --   输入 4,1   ok
	     * 2        4         2             4,2   ok
	     * 3        4         3             4,3   ok
		 */
		//第一次进入初始化，没有点上一页，下一页
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
		request.put("list", this.service.findPageByPageTotalRowAndPage(pageSize,this.page));
		request.put("page", this.page);
		request.put("totalPage",totalPage);
		request.put("totalRow", this.service.findTotalRow());

		return SUCCESS;
	}
}
