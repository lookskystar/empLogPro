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
 * spring���ʼ���������
 * 
 * @author Amigo Xie(xiexingxing1121@126.com)
 * @since 2007/04/28 11:30
 */
public class SpringMailServiceImpl {
	
	// ��������������������
	public final String regex1 = ".*[<][^>]*[>].*"; // �ж��� xxxx <xxx>��ʽ�ı�
	public final String regex2 = "<([^>]*)>"; // ������ƥ��
	
	
	
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
//		//��ʼ������ֻ������һ��;���ж�εĻ����������������
//		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//log.info("hello commons-logging!");
//		//taskExecutor = (TaskExecutor) ctx.getBean("taskExecutor", TaskExecutor.class);
//		for (int i = 0; i < 500; i++) {
//			// �˴���������ʵ��,�����ǿ�����������ʽʵ��
//			taskExecutor.execute(new Runnable() {
//				public void run() {
//					//log.info("hello spring " + TaskExecutor.class.getName());
//					try {
//						System.out.println("��ʼ���̷߳���.............");
//						
//						Thread.currentThread();
//						Thread.sleep(5000);// Ϊ��Ч������,���������ӳ�һ��
//						System.out.println("��");
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
	
	// ��������������������
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
	 * ���Է���ֻ���ı���Ϣ�ļ򵥲���
	 * 
	 * @param sender
	 *            �ʼ�������
	 *     sender:�ʼ�����������Ϣ
	 *     from:������
	 *     to���ռ���
	 *     subject������
	 *     text���ı�����       
	 * @throws Exception
	*/
	public void sendTextMail(final JavaMailSender sender,String from,String to,String subject,String text) throws Exception {
		//System.out.println("���ڷ��͵�-->"+to);
		SimpleMailMessage mail = new SimpleMailMessage();
		//mail.setTo("lookskystar1@163.com");
		mail.setTo(to);
		//mail.setFrom("20111122@mail2.itleader.org");
		mail.setFrom(from);
		//mail.setSubject("test by amigo");
		mail.setSubject(subject);
		//mail.setText("spring Mail�ļ򵥲���");
		mail.setText(text);
		sender.send(mail);
		//System.out.println("�ɹ������ı��ļ���");
	}
	
	/** */
	/**
	 * ���ʹ��������ʼ�
	 * 
	 * @param sender
	 *            �ʼ�������
	 *            sender:�����ʼ�����������
	 *            from�������˵�ַ�����ʼ�����������ʵ����
	 *            to���ռ��˵�ַ
	 *            subject���ʼ�����
	 *            contentText������
	 *            accessoryList������·������
	 * @throws Exception
	*/
	private List files = new ArrayList();
	public void sendMimeMessage(final JavaMailSender sender,final String from,final String to,final String subject,final String contentText,final List accessoryList ) throws Exception {
		//System.out.println("���ڷ��͵�-->"+to);
		// �����ļ�����
		files=accessoryList;
		MimeMessagePreparator mimeMail = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)throws MessagingException {
				//mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("lookskystar1@163.com"));
				mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
				//mimeMessage.setFrom(new InternetAddress("20111122@mail2.itleader.org"));
				mimeMessage.setFrom(new InternetAddress(from));
				//mimeMessage.setSubject("Spring���ʹ��������ʼ�", "gb2312");
				mimeMessage.setSubject(subject, "gb2312");

				Multipart mp = new MimeMultipart();

				// ��Multipart�������
				MimeBodyPart content = new MimeBodyPart();
				//content.setText("�ں�spring�ʼ����͵����ӣ������!");
				content.setText(contentText);
				
				// ��MimeMessage��ӣ�Multipart�������ģ�
				mp.addBodyPart(content);
				//���������������������
				sun.misc.BASE64Encoder enc=new sun.misc.BASE64Encoder();
				//files.add("D:\\������.xml");
				// ��Multipart��Ӹ���
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

				// ��Multipart���MimeMessage
				mimeMessage.setContent(mp);
				mimeMessage.setSentDate(new Date());
			}
		};

		// ���ʹ��������ʼ�
		sender.send(mimeMail);

		System.out.println("�ɹ����ʹ������ʼ�!");

	}
	
	
	/*
	 * ����html�ʼ�,������
	 */
	public void sendHtmlMessage(final JavaMailSender sender,final String from,final String to,final String subject,final String contentText,final List accessoryList ) throws Exception {
		try {
			//System.out.println("���ڷ��͵�-->"+to);
			
			MimeMessage mimeMessage=sender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true,"GBK");
			
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setFrom(getFromInternetAddress(from));
			mimeMessageHelper.setSubject(subject);
			
			//�Ӹ���
			mimeMessageHelper.addAttachment(MimeUtility.encodeWord("������"),new File("D:\\������.xml"));
			//html�ʼ�
			mimeMessageHelper.setText(contentText, true);
			
			sender.send(mimeMessage);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println("�ɹ�����html�ʼ���������.....");
	}
}
	 