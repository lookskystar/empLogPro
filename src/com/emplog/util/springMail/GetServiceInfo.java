package com.emplog.util.springMail;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * �ʼ��򿪻�ִ�����࣬
 * �õ������ʼ�������ip��
 * �õ�DNS 
 * û����ɣ���õõ�һ��InetAddress ip��ַ����

 */
public class GetServiceInfo {
	private  String  myIPaddress=null;
	private  String myServer=null;

	//�õ�����ip
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
