package com.emplog.util.springMail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ��ȡhtmlģ������,���滻ͷ���ס����ݣ����Ϊ�գ����滻��
 */
public class IndividualiyHtmlTemplate {

	public String jspToHtmlFileContent(String filePath,String head,String floor,String content){
		String str = "";
         //long beginDate = (new Date()).getTime();
         try {
                 String tempStr = "";
                // System.out.println(filePath);
                 File file=new File(filePath);
                 if(file.isFile()){
                	 //System.out.println("ģ�����....");
                	 FileInputStream is = new FileInputStream(filePath);//��ȡģ���ļ�
                     BufferedReader br = new BufferedReader(new InputStreamReader(is));
                     while ((tempStr = br.readLine()) != null)
                     str = str + tempStr ;
                     
                     str=str.replace("{head}", head);
                     str=str.replace("{floor}", floor);
                     str=str.replace("{content}", content);
                     
                     is.close();
                 }
                 
                
         } catch (IOException e) {
                 e.printStackTrace();
                 return str;
         }
        // System.out.println("str--->"+str);
        
         
         
         return str;
         
         
         
       /*  ���³�����ʱû���õ����õ����е�title��content��editer����ʼ�ͽ�����ʱ��
       try {
          
   str = str.replaceAll("###title###",
       title);
   str = str.replaceAll("###content###",
       context);
   str = str.replaceAll("###author###",
       editer);//�滻��ģ������Ӧ�ĵط�
   
               //File f = new File(HtmlFile);
               //BufferedWriter o = new BufferedWriter(new FileWriter(f));
               //o.write(str);
               //o.close();
               System.out.println("����ʱ��" + ((new Date()).getTime() - beginDate) + "ms");
       } catch (IOException e) {
               e.printStackTrace();
               return false;
       }
       return true;
       */
         
         
	}
}
