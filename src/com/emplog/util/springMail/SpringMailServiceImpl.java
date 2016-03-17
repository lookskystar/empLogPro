package com.emplog.util.springMail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.Multipart;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** */
/**
 * spring的邮件发送例子
 * 
 * @author Amigo Xie(xiexingxing1121@126.com)
 * @since 2007/04/28 11:30
 */
public class SpringMailServiceImpl {
	
	// 发件人名中文乱码问题
	public final String regex1 = ".*[<][^>]*[>].*"; // 判断是 xxxx <xxx>格式文本
	public final String regex2 = "<([^>]*)>"; // 尖括号匹配
	
	
	
/*
//private  TaskExecutor taskExecutor;  
//	private  JavaMailSender sender;
//
//	public TaskExecutor getTaskExecutor() {
//		return taskExecutor;
//	}
//	public void setTaskExecutor(TaskExecutor taskExecutor) {
//		this.taskExecutor = taskExecutor;
//	}
//	public JavaMailSender getSender() {
//		return sender;
//	}
//	public void setSender(JavaMailSender sender) {
//		this.sender = sender;
//	}

	
//	public void startSend() throws Exception {
//	
//		
//		//ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				//"applicationContext.xml");
//		//final JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");
//		//final SpringMailServiceImpl springMail = new SpringMailServiceImpl();
//		
//		
//		//初始化工作只能运行一次;运行多次的话，会启动多个服务
//		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//log.info("hello commons-logging!");
//		//taskExecutor = (TaskExecutor) ctx.getBean("taskExecutor", TaskExecutor.class);
//		for (int i = 0; i < 500; i++) {
//			// 此处用匿名类实现,朋友们可以用其他方式实现
//			taskExecutor.execute(new Runnable() {
//				public void run() {
//					//log.info("hello spring " + TaskExecutor.class.getName());
//					try {
//						System.out.println("开始多线程发送.............");
//						
//						Thread.currentThread();
//						Thread.sleep(5000);// 为了效果明显,所以在这延迟一下
//						System.out.println("第");
//						 //springMail.sendMimeMessage(sender);
//						sendTextMail(sender);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					} catch (Exception e) {
//						Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			});
//		}
//	}

*/	
	
	// 发件人名中文乱码问题
	public InternetAddress getFromInternetAddress(String from) {
		String personal = null;
		String address = null;

		if (from.matches(regex1)) {
			personal = from.replaceAll(regex2, "").trim();
			Matcher m = Pattern.compile(regex2).matcher(from);
			if (m.find()) {
				address = m.group(1).trim();
			}
			try {
				return new InternetAddress(address, personal, "gb2312");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			try {
				return new InternetAddress(from);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	
	

	/** */
	/**
	 * 测试发送只有文本信息的简单测试
	 * 
	 * @param sender
	 *            邮件发送器
	 *     sender:邮件服务配置信息
	 *     from:发件人
	 *     to：收件人
	 *     subject：标题
	 *     text：文本内容       
	 * @throws Exception
	*/
	public void sendTextMail(final JavaMailSender sender,String from,String to,String subject,String text) throws Exception {
		//System.out.println("正在发送第-->"+to);
		SimpleMailMessage mail = new SimpleMailMessage();
		//mail.setTo("lookskystar1@163.com");
		mail.setTo(to);
		//mail.setFrom("20111122@mail2.itleader.org");
		mail.setFrom(from);
		//mail.setSubject("test by amigo");
		mail.setSubject(subject);
		//mail.setText("spring Mail的简单测试");
		mail.setText(text);
		sender.send(mail);
		//System.out.println("成功发送文本文件！");
	}
	
	/** */
	/**
	 * 发送带附件的邮件
	 * 
	 * @param sender
	 *            邮件发送器
	 *            sender:发送邮件服务器设置
	 *            from：发件人地址，在邮件服务器中真实存在
	 *            to：收件人地址
	 *            subject：邮件主题
	 *            contentText：内容
	 *            accessoryList：附件路径集合
	 * @throws Exception
	*/
	private List files = new ArrayList();
	public void sendMimeMessage(final JavaMailSender sender,final String from,final String to,final String subject,final String contentText,final List accessoryList ) throws Exception {
		//System.out.println("正在发送第-->"+to);
		// 附件文件集合
		files=accessoryList;
		MimeMessagePreparator mimeMail = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)throws MessagingException {
				//mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("lookskystar1@163.com"));
				mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
				//mimeMessage.setFrom(new InternetAddress("20111122@mail2.itleader.org"));
				mimeMessage.setFrom(new InternetAddress(from));
				//mimeMessage.setSubject("Spring发送带附件的邮件", "gb2312");
				mimeMessage.setSubject(subject, "gb2312");

				Multipart mp = new MimeMultipart();

				// 向Multipart添加正文
				MimeBodyPart content = new MimeBodyPart();
				//content.setText("内含spring邮件发送的例子，请查收!");
				content.setText(contentText);
				
				// 向MimeMessage添加（Multipart代表正文）
				mp.addBodyPart(content);
				//解决附件名中文乱码问题
				sun.misc.BASE64Encoder enc=new sun.misc.BASE64Encoder();
				//files.add("D:\\贾秋林.xml");
				// 向Multipart添加附件
				Iterator it = files.iterator();
				while (it.hasNext()) {
					MimeBodyPart attachFile = new MimeBodyPart();
					String filename = it.next().toString();
					FileDataSource fds = new FileDataSource(filename);
					attachFile.setDataHandler(new DataHandler(fds));
					//attachFile.setFileName(fds.getName());
					attachFile.setFileName("=?GBK?B?"+enc.encode(fds.getName().getBytes())+"?=");
					mp.addBodyPart(attachFile);
				}

				files.clear();

				// 向Multipart添加MimeMessage
				mimeMessage.setContent(mp);
				mimeMessage.setSentDate(new Date());
			}
		};

		// 发送带附件的邮件
		sender.send(mimeMail);

		System.out.println("成功发送带附件邮件!");

	}
	
	
	/*
	 * 发送html邮件,带附件
	 */
	public void sendHtmlMessage(final JavaMailSender sender,final String from,final String to,final String subject,final String contentText,final List accessoryList ) throws Exception {
		try {
			//System.out.println("正在发送第-->"+to);
			
			MimeMessage mimeMessage=sender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true,"GBK");
			
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setFrom(getFromInternetAddress(from));
			mimeMessageHelper.setSubject(subject);
			
			//加附件
			mimeMessageHelper.addAttachment(MimeUtility.encodeWord("贾秋林"),new File("D:\\贾秋林.xml"));
			//html邮件
			mimeMessageHelper.setText(contentText, true);
			
			sender.send(mimeMessage);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println("成功发送html邮件，带附件.....");
	}
}
	 