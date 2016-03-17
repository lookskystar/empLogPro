package com.emplog.util.springMail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 读取邮件发送用户地址（读取txt文件）
 */
public class ReadTxt {
	
	List emailAddressArrayList =null;//用于保存发送附件的文件名列表
	
	public  List readContent(String txtPath) throws IOException{
		String tempStr=""; //存放读取出来的邮件地址数据
		
		
		//System.out.println(txtPath);
		//判断该文件是否存在，如果存在则读取里面的内容，否则不读取
		File file=new File(txtPath);
		if(file.isFile()){
			//System.out.println("地址存在....");
			FileInputStream fileInputStream = new FileInputStream(txtPath);//读取txt
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 建立对象bufferedReader 
			
			//把str里面的数据按,分组放到集合中，并计算出用户邮箱地址个数
		    emailAddressArrayList=new ArrayList();
		    while ((tempStr = bufferedReader.readLine()) != null)
		    {
		    	//加入邮件地址到集合    
		    	emailAddressArrayList.add(tempStr);
		    }
		    
		    //关闭数据流和读取流
		    fileInputStream.close();
		    bufferedReader.close(); 
		}
		//System.out.println("emailAddressArrayList-->"+emailAddressArrayList);
		return emailAddressArrayList;
		
		
	    

	    /*读取html文件1 例子（读网页例子）
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
