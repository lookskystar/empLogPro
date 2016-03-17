package com.emplog.util.springMail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.proxy.dwr.Util;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;



public class StartMailSender {
	private TaskExecutor taskExecutor;
	private JavaMailSender sender;
	
	
	///////////////���͡���ȡmailע��
	private ReadTxt readTxt;
	private SpringMailServiceImpl springMailServiceImpl;
	private IndividualiyHtmlTemplate individualiyHtmlTemplate;
	private WriteTxt writeTxt;
	
	
	

	
	
	public ReadTxt getReadTxt() {
		return readTxt;
	}
	public void setReadTxt(ReadTxt readTxt) {
		this.readTxt = readTxt;
	}
	public SpringMailServiceImpl getSpringMailServiceImpl() {
		return springMailServiceImpl;
	}
	public void setSpringMailServiceImpl(SpringMailServiceImpl springMailServiceImpl) {
		this.springMailServiceImpl = springMailServiceImpl;
	}
	public IndividualiyHtmlTemplate getIndividualiyHtmlTemplate() {
		return individualiyHtmlTemplate;
	}
	public void setIndividualiyHtmlTemplate(
			IndividualiyHtmlTemplate individualiyHtmlTemplate) {
		this.individualiyHtmlTemplate = individualiyHtmlTemplate;
	}
	public WriteTxt getWriteTxt() {
		return writeTxt;
	}
	public void setWriteTxt(WriteTxt writeTxt) {
		this.writeTxt = writeTxt;
	}
	//////////////
	
	
	
	

	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}
	

	
	
	

	//private List emailAddressArrayList =null;//���ڱ��淢�͸������ļ����б�
	//private String emailAddress=null;
	/*
	 * ��ʼ�����ʼ�
	 * senderAddress�������˵�ַ����ʵ���ڣ����ʼ���������
	 * receiveAddressList���ռ��˼���
	 * subject:����
	 * content������     ���Ի�html ��html ������{name}��ǣ�Ȼ������Ի����ݣ��滻�����ǡ�
	 * accessoryList:����·������
	 * logPath:��־·��
	 */                                                             
	public void startSender(final String senderAddress,List receiveAddressList,final String subject,final String content,final List accessoryList,final String logPath) throws IOException, InterruptedException {
		List emailAddressArrayList=new ArrayList();
		//String emailAddress=null;
		 emailAddressArrayList=receiveAddressList; //����
		 final String contentStr=content;  //���Ը��Ի��ʼ�ģ��
		 //emailAddressArrayList=receiveAddressList; //���洫�����ļ���
		 // ���Զ��̷߳����ʼ�
		 //final SpringMailServiceImpl s = new SpringMailServiceImpl();
		for (int i = 0; i < emailAddressArrayList.size(); i++) {
			final String emailAddress=emailAddressArrayList.get(i).toString();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			final String msg="һ��Ҫ���ͣ�"+emailAddressArrayList.size()+"���ʼ������ڷ��͵�"+i+"��-->"+emailAddress+"--><<TIME>>..."+sdf.format(new Date());
			
			taskExecutor.execute(new Runnable() {
				public void run() {
					//String emailStr=null;
					try {
//						for (int j = 0; j < emailAddressArrayList.size(); j++) {
							//System.out.println(emailAddressArrayList.get(j).toString());
							//springMailServiceImpl.sendTextMail(sender, senderAddress, emailAddressArrayList.get(j).toString(), subject, content);
						//}
                        //html���벻�ܽ���������Ҫ���ɷ���html���ʼ���html����ӷ�������
						//springMailServiceImpl.sendTextMail(sender, senderAddress, emailAddress, subject, content);
						//springMailServiceImpl.sendMimeMessage(sender,senderAddress,emailAddress,subject,content,accessoryList);
						//Thread.sleep(5000);
						springMailServiceImpl.sendHtmlMessage(sender, senderAddress, emailAddress, subject, contentStr, accessoryList);
						writeLog(msg+"�ɹ�...",logPath);  //���ͳɹ���һ��ַ��
						
					} catch (Exception e) {
						writeLog(msg+"ʧ��***",logPath);  //����ʧ��
						e.printStackTrace();
					}
					
				}
				
			});
			
			//System.out.println(i);
			//writeLog(msg+"�ɹ�...",logPath);  //���ͳɹ���һ��ַ��
		}
	}
	
	
	//���ͳɹ����
	public void writeLog(String emailAddress,String logPath){
		//д���ɹ���־��
		writeTxt.writeContent(emailAddress, logPath);
	}
}
