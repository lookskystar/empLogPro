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
	// ���Է����ʼ�
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

	// ҳ������
	private String senderaddress; // �ռ��˵�ַ
	private String sendername; // ����������
	private String head; // ���Ի�ͷ
	private String floor; // ���Ի���
	private String content; // �м�����
	private String subject; // �ʼ�����



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

	// ҳ������
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

		// final List list=new ArrayList(); //�ռ��˵�ַ����
		// final String htmlStr=null;
		String fileBasePath = ServletActionContext.getServletContext()
				.getRealPath("/"); // ��·��
		String emailAddressPath = fileBasePath
				+ "/uploading/user_mail/emailAddress.txt"; // �������ʼ���ַ�ı�·��
		String templatePath = fileBasePath
				+ "/uploading/user_mail/template.html"; // ģ��·��
		final String logPath = fileBasePath + "/uploading/user_mail/log.txt"; // ģ��·��
		// ��ȡ�ʼ���ַ�ļ�emailAddress.txt
		final List list = readTxt.readContent(emailAddressPath);
		// ��ȡ�ʼ�ģ��template.html() //(String filePath,String head,String
		// bottom,String content)
		final String htmlStr = individualiyHtmlTemplate.jspToHtmlFileContent(
				templatePath, head, floor, subject);

		if (list == null || "".equals(htmlStr)) {
			System.out.println("û���ļ���ȡ");
			request.put("msg",
					"���ϴ���ȷ�ġ�emailAddress.txt���͡�template.html�������ļ�......");
			return ERROR;
		} else {
			// for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			// }

			// ���Է����ʼ�
			/*
			 * ��ʼ�����ʼ� senderAddress�������˵�ַ����ʵ���ڣ����ʼ��������� receiveAddressList���ռ��˼���
			 * content��htmlģ������ accessoryList������·�����ϣ�ȱ�ٶ�ȡ����Ŀ¼���ļ���user_file��������
			 */
			// ���д�����ƣ����ռ������Ʒ���
			System.out.println(this.sendername);
			if (!"".equals(this.sendername)) {
				//System.out.println("�����Ʒ���");
				senderaddress = sendername + "<" + senderaddress + ">";
			}
			request.put("mailStaticMsg", "���ͽ���ʱ......�����뿪��ҳ�棬��������������");			
			startMailSender.startSender(senderaddress, list, subject, htmlStr,null, logPath);
			// Thread.sleep(5000);
			// System.out.println("�߳̽���");
			return SUCCESS;
		}
	}
}
