package com.emplog.util.springMail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 读取html模板内容,并替换头、底、内容（如果为空，则不替换）
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
                	 //System.out.println("模板存在....");
                	 FileInputStream is = new FileInputStream(filePath);//读取模块文件
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
         
         
         
       /*  以下程序暂时没有用到，得到所有的title，content和editer，开始和结束的时间
       try {
          
   str = str.replaceAll("###title###",
       title);
   str = str.replaceAll("###content###",
       context);
   str = str.replaceAll("###author###",
       editer);//替换掉模块中相应的地方
   
               //File f = new File(HtmlFile);
               //BufferedWriter o = new BufferedWriter(new FileWriter(f));
               //o.write(str);
               //o.close();
               System.out.println("共用时：" + ((new Date()).getTime() - beginDate) + "ms");
       } catch (IOException e) {
               e.printStackTrace();
               return false;
       }
       return true;
       */
         
         
	}
}
