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
	
	
	///////////////发送、读取mail注入
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
	

	
	
	

	//private List emailAddressArrayList =null;//用于保存发送附件的文件名列表
	//private String emailAddress=null;
	/*
	 * 开始发送邮件
	 * senderAddress：发件人地址，真实存在，在邮件服务器中
	 * receiveAddressList：收件人集合
	 * subject:主题
	 * content：内容     个性化html 在html 加上如{name}标记，然后传入个性化内容，替换这个标记。
	 * accessoryList:附件路径集合
	 * logPath:日志路径
	 */                                                             
	public void startSender(final String senderAddress,List receiveAddressList,final String subject,final String content,final List accessoryList,final String logPath) throws IOException, InterruptedException {
		List emailAddressArrayList=new ArrayList();
		//String emailAddress=null;
		 emailAddressArrayList=receiveAddressList; //测试
		 final String contentStr=content;  //测试个性化邮件模板
		 //emailAddressArrayList=receiveAddressList; //外面传进来的集合
		 // 测试多线程发送邮件
		 //final SpringMailServiceImpl s = new SpringMailServiceImpl();
		for (int i = 0; i < emailAddressArrayList.size(); i++) {
			final String emailAddress=emailAddressArrayList.get(i).toString();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			final String msg="一共要发送："+emailAddressArrayList.size()+"封邮件，正在发送第"+i+"封-->"+emailAddress+"--><<TIME>>..."+sdf.format(new Date());
			
			taskExecutor.execute(new Runnable() {
				public void run() {
					//String emailStr=null;
					try {
//						for (int j = 0; j < emailAddressArrayList.size(); j++) {
							//System.out.println(emailAddressArrayList.get(j).toString());
							//springMailServiceImpl.sendTextMail(sender, senderAddress, emailAddressArrayList.get(j).toString(), subject, content);
						//}
                        //html代码不能解析，我们要做成发送html的邮件，html中添加发送内容
						//springMailServiceImpl.sendTextMail(sender, senderAddress, emailAddress, subject, content);
						//springMailServiceImpl.sendMimeMessage(sender,senderAddress,emailAddress,subject,content,accessoryList);
						//Thread.sleep(5000);
						springMailServiceImpl.sendHtmlMessage(sender, senderAddress, emailAddress, subject, contentStr, accessoryList);
						writeLog(msg+"成功...",logPath);  //发送成功（一地址）
						
					} catch (Exception e) {
						writeLog(msg+"失败***",logPath);  //发送失败
						e.printStackTrace();
					}
					
				}
				
			});
			
			//System.out.println(i);
			//writeLog(msg+"成功...",logPath);  //发送成功（一地址）
		}
	}
	
	
	//发送成功完成
	public void writeLog(String emailAddress,String logPath){
		//写到成功日志中
		writeTxt.writeContent(emailAddress, logPath);
	}
}
