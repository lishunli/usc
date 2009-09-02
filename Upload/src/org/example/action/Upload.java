package org.example.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport
{

	/**
	 * 
	 */

	private static final long serialVersionUID = -8204063374280945416L;

	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;

	public File getUpload()
	{
		return upload;
	}

	public void setUpload(File upload)
	{
		this.upload = upload;
	}

	public String getUploadContentType()
	{
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath()
	{
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath)
	{
		this.savePath = savePath;
	}

	public String upload() throws Exception
	{
		// 得到上传文件的后缀名
		String b = getUploadContentType();
		String houzhui = b.substring(b.indexOf("/") + 1, b.length());
		houzhui = (houzhui.equals("pjpeg") ? "jpg" : houzhui);

		// 得到文件的新名字

		String a = upload.getName();
		String mingzi = a.substring(0, a.length() - 3) + houzhui;

		System.out.println("mingzi:======"+mingzi);
		// 创建文件
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ mingzi);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer, 0, len);
		}
		return SUCCESS;
	}

	public String getUploadFileName()
	{
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}
}