package com.emplog.action.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.struts2.ServletActionContext;
import org.springframework.core.task.TaskExecutor;

import com.emplog.util.springMail.IndividualiyHtmlTemplate;
import com.emplog.util.springMail.ReadTxt;
import com.emplog.util.springMail.StartMailSender;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MailSenderAction extends ActionSupport {
	// 测试发送邮件
	private StartMailSender startMailSender;
	private ReadTxt readTxt;
	private IndividualiyHtmlTemplate individualiyHtmlTemplate;

	private TaskExecutor taskExecutor;

	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	// 页面属性
	private String senderaddress; // 收件人地址
	private String sendername; // 发件人姓名
	private String head; // 个性化头
	private String floor; // 个性化底
	private String content; // 中间内容
	private String subject; // 邮件主题



	public StartMailSender getStartMailSender() {
		return startMailSender;
	}

	public void setStartMailSender(StartMailSender startMailSender) {
		this.startMailSender = startMailSender;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public ReadTxt getReadTxt() {
		return readTxt;
	}

	public void setReadTxt(ReadTxt readTxt) {
		this.readTxt = readTxt;
	}

	public IndividualiyHtmlTemplate getIndividualiyHtmlTemplate() {
		return individualiyHtmlTemplate;
	}

	public void setIndividualiyHtmlTemplate(
			IndividualiyHtmlTemplate individualiyHtmlTemplate) {
		this.individualiyHtmlTemplate = individualiyHtmlTemplate;
	}

	// 页面属性
	public String getSenderaddress() {
		return senderaddress;
	}

	public void setSenderaddress(String senderaddress) {
		this.senderaddress = senderaddress;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	@Override
	public String execute() throws Exception {
		// System.out.println(senderaddress+":"+head+":"+floor+":"+content+":"+subject);
		Map request = (Map) ActionContext.getContext().get("request");

		// final List list=new ArrayList(); //收件人地址集合
		// final String htmlStr=null;
		String fileBasePath = ServletActionContext.getServletContext()
				.getRealPath("/"); // 主路径
		String emailAddressPath = fileBasePath
				+ "/uploading/user_mail/emailAddress.txt"; // 接收人邮件地址文本路径
		String templatePath = fileBasePath
				+ "/uploading/user_mail/template.html"; // 模板路径
		final String logPath = fileBasePath + "/uploading/user_mail/log.txt"; // 模板路径
		// 读取邮件地址文件emailAddress.txt
		final List list = readTxt.readContent(emailAddressPath);
		// 读取邮件模板template.html() //(String filePath,String head,String
		// bottom,String content)
		final String htmlStr = individualiyHtmlTemplate.jspToHtmlFileContent(
				templatePath, head, floor, subject);

		if (list == null || "".equals(htmlStr)) {
			System.out.println("没有文件读取");
			request.put("msg",
					"请上传正确的【emailAddress.txt】和【template.html】两个文件......");
			return ERROR;
		} else {
			// for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			// }

			// 测试发送邮件
			/*
			 * 开始发送邮件 senderAddress：发件人地址，真实存在，在邮件服务器中 receiveAddressList：收件人集合
			 * content：html模板内容 accessoryList：附件路径集合（缺少读取附件目录下文件（user_file）方法）
			 */
			// 如果写了名称，则按照加入名称发送
			System.out.println(this.sendername);
			if (!"".equals(this.sendername)) {
				//System.out.println("无名称发送");
				senderaddress = sendername + "<" + senderaddress + ">";
			}
			request.put("mailStaticMsg", "发送进行时......（可离开此页面，继续其他工作）");			
			startMailSender.startSender(senderaddress, list, subject, htmlStr,null, logPath);
			// Thread.sleep(5000);
			// System.out.println("线程结束");
			return SUCCESS;
		}
	}
}
