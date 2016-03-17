package com.emplog.action.mail;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;




import org.apache.commons.fileupload.util.Streams;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MailUploadAction extends ActionSupport {

	private File[] file;
    private String[] fileFileName;         
    private String[] fileContentType;
	
	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	HttpServletResponse response = ServletActionContext.getResponse();
	String fileBasePath = ServletActionContext.getServletContext().getRealPath("/");

	/**
	 * 上传
	 * 
	 * @throws IOException
	 */
	

	public void uploadFileing() throws IOException {
		//System.out.println("myFiles---->"+this.myFileFileName+":"+this.myFileContentType);
		//System.out.println("myFiles---->"+uploadFiles.length);
		//System.out.println("myFiles---->"+this.getUploadFilesNames().length);
		
		response.setCharacterEncoding("utf-8");
		File user_file = new File(fileBasePath + "/uploading/user_file/");
		File user_mail = new File(fileBasePath + "/uploading/user_mail/");
		
		if (!user_file.exists()) {
			user_file.mkdirs();
		}
		if (!user_mail.exists()) {
			user_mail.mkdirs();
		}

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		for (int i = 0, size = file.length; i < size; i++) {
			File fileObj = file[i];	
			//System.out.println("fileFileName----->"+fileFileName[i]);
			String fileNameStr=fileFileName[i];
			//String fileContentTypeStr=fileContentType[i];
			try {
				bis = new BufferedInputStream(new FileInputStream(fileObj));
				//String imageName = fileNameStr;
				//String imageName  = new Date().getTime()+".png";     
				//根据上传的文件名关键字来判断上传的文件是附件还是发送信息（emailAddress.txt、template.html）来确定所存放的文件夹
				if(("emailAddress.txt".equals(fileNameStr))||("template.html".equals(fileNameStr))){
					bos = new BufferedOutputStream(new FileOutputStream(new File(
							user_mail.getPath() + "/" + fileNameStr)));
				}else{
					bos = new BufferedOutputStream(new FileOutputStream(new File(
							user_file.getPath() + "/" + fileNameStr)));
				}
				Streams.copy(bis, bos, true);
			} catch (Exception e) {
				response.getWriter().print("上传出错！");
				e.printStackTrace();
			}
		}

		try {
			//{data:'success',success:true}
			//,{'success':true,'fileName':'"+fileName+"','message':'success!'}
			response.getWriter().print("{data:'success',success:true}");
		} catch (IOException e) {

		}
	}
}
