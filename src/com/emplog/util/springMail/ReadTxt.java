package com.emplog.util.springMail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * ��ȡ�ʼ������û���ַ����ȡtxt�ļ���
 */
public class ReadTxt {
	
	List emailAddressArrayList =null;//���ڱ��淢�͸������ļ����б�
	
	public  List readContent(String txtPath) throws IOException{
		String tempStr=""; //��Ŷ�ȡ�������ʼ���ַ����
		
		
		//System.out.println(txtPath);
		//�жϸ��ļ��Ƿ���ڣ�����������ȡ��������ݣ����򲻶�ȡ
		File file=new File(txtPath);
		if(file.isFile()){
			//System.out.println("��ַ����....");
			FileInputStream fileInputStream = new FileInputStream(txtPath);//��ȡtxt
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// ��������bufferedReader 
			
			//��str��������ݰ�,����ŵ������У���������û������ַ����
		    emailAddressArrayList=new ArrayList();
		    while ((tempStr = bufferedReader.readLine()) != null)
		    {
		    	//�����ʼ���ַ������    
		    	emailAddressArrayList.add(tempStr);
		    }
		    
		    //�ر��������Ͷ�ȡ��
		    fileInputStream.close();
		    bufferedReader.close(); 
		}
		//System.out.println("emailAddressArrayList-->"+emailAddressArrayList);
		return emailAddressArrayList;
		
		
	    

	    /*��ȡhtml�ļ�1 ���ӣ�����ҳ���ӣ�
		StringBuffer document = new StringBuffer();
	    try 
	    {
	        URL url = new URL("http://www.163.com");
	        URLConnection conn = url.openConnection();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null)
	        document.append(line + " ");
	        reader.close();
	    }
	    catch (MalformedURLException e) 
	    {
	        e.printStackTrace(); 
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace(); 
	    }
	    System.out.println(document.toString());
	    
	    */
	}
	
}
