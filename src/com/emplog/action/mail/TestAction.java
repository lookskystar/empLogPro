package com.emplog.action.mail;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("统计开始了......");
		return SUCCESS;
	}
}
