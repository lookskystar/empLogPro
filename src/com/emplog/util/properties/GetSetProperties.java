package com.emplog.util.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.opensymphony.xwork2.config.Configuration;

/*
 * ��ȡWebRoot/WEB-INF/conf/�������ļ�������
 * ����
 * propertiesName�������ļ��������磺mail.properties
 * propertyKey�������������磺mail.host
 */
public class GetSetProperties {
	public HashMap readProerties(String propertiesName,List propertyKeyList){

		HashMap propertyKeyValueMap=new HashMap();
		try {
			 String url= this.getClass().getResource("").getPath().replaceAll("%20", " ");
			 String path = url.substring(0, url.indexOf("WEB-INF")) + "WEB-INF/conf/"+propertiesName;   

			 Properties config = new Properties(); 
			 config.load(new FileInputStream(path));   
			 
			 for (int i = 0; i <propertyKeyList.size(); i++) {
				 //System.out.println(propertyKeyList.get(i).toString()+"-----"+config.getProperty(propertyKeyList.get(i).toString()));
				 propertyKeyValueMap.put(propertyKeyList.get(i).toString(), config.getProperty(propertyKeyList.get(i).toString()));
			 }
			 
			 Iterator iter = propertyKeyValueMap.entrySet().iterator();
			 while (iter.hasNext()) {
				  Map.Entry entry = (Map.Entry) iter.next();
				  Object key = entry.getKey();
				  Object val = entry.getValue();
				  //System.out.println(key+":"+val);
			}		 
			 return propertyKeyValueMap; 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null; 
	}	
}
