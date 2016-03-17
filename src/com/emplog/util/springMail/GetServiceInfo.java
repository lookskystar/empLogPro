package com.emplog.util.springMail;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 邮件打开回执帮助类，
 * 得到发送邮件服务器ip；
 * 得到DNS 
 * 没有完成，因该得到一个InetAddress ip地址数据

 */
public class GetServiceInfo {
	private  String  myIPaddress=null;
	private  String myServer=null;

	//得到本地ip
	public String getSericeIp(){
		try {
			myIPaddress=InetAddress.getLocalHost().getHostAddress();
			return myIPaddress;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//
}
