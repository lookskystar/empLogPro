package com.emplog.action.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.emplog.util.properties.GetSetProperties;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MailPageAction extends ActionSupport {
	
	private GetSetProperties getSetProperties;
	public GetSetProperties getGetSetProperties() {
		return getSetProperties;
	}
	public void setGetSetProperties(GetSetProperties getSetProperties) {
		this.getSetProperties = getSetProperties;
	}



	@Override
	public String execute() throws Exception {
		Map request=(Map)ActionContext.getContext().get("request");
		List propertyKeyList=new ArrayList();
		HashMap propertyKeyValueMap=new HashMap();
		
		String mailProperties="mail.properties";
		
		String mailProtocol="mail.protocol";
		String mailHost="mail.host";
		String mailUsername="mail.username";
		String mailPassword="mail.password";
		
		propertyKeyList.add(mailProtocol);
		propertyKeyList.add(mailHost);
		propertyKeyList.add(mailUsername);
		propertyKeyList.add(mailPassword);
		
		propertyKeyValueMap=this.getSetProperties.readProerties(mailProperties,propertyKeyList);
//		System.out.println(propertyKeyValueMap.size());
		
		Iterator iter = propertyKeyValueMap.entrySet().iterator();
		 while (iter.hasNext()) {
			  Map.Entry entry = (Map.Entry) iter.next();
			  Object key = entry.getKey();
			  Object val = entry.getValue();
			 // System.out.println(key+":--:"+val);
			  request.put((key.toString()).replace(".", ""), val);
			}
		 
		 request.put("mail", "mail.protocol");
		
//		 System.out.println(request.get("mailprotocol"));
//		 System.out.println(request.get("mailhost"));
//		 System.out.println(request.get("mailusername"));
//		 System.out.println(request.get("mailpassword"));
		 
		return SUCCESS;
	}
}
