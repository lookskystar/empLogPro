package com.emplog.util.springMail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteTxt {
	public void writeContent(String content, String filePath) {
		// System.out.println("------>:"+filePath);
		FileWriter fw = null;
		BufferedWriter bw = null;
		System.out.println(content);
		//String str = content + "\r\n";
		try {
			File file = new File(filePath);

			if (!file.isFile()) {
				file.createNewFile();
			}

			  fw =new FileWriter(filePath,true);   
	          fw.append(content);   
	          fw.append("\r\n");
	          fw.flush();
	          fw.close();   


//			fis = new FileOutputStream(filePath);
//			bw = new BufferedWriter(new OutputStreamWriter(fis));
//			bw.append(content);
//			bw.flush();
			//System.out.println("写入文件完成!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
//				if (bw != null)
//					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
