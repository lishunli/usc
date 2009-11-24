package org.usc.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.usc.utils.UploadFilePath;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport
{

	private File[] upload;// 实际上传文件
	private String[] uploadContentType; // 文件的内容类型
	private String[] uploadFileName; // 上传文件名
	private List<UploadFiles> uploadFiles = new ArrayList<UploadFiles>();

	public String execute() throws Exception
	{
		try
		{
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(
							"/"
									+ new UploadFilePath().p.getProperty(
											"uploadFilePath").trim());//获得路径
			for (int i = 0; i < upload.length; i++)
			{
				String fileName = uploadFileName[i];
				String type = uploadContentType[i];
				String realName = UUID.randomUUID().toString()
						+ getExt(fileName);

				File target = new File(targetDirectory, realName);
				FileUtils.copyFile(upload[i], target);

				UploadFiles uf = new UploadFiles();
				uf.setUploadContentType(type);
				uf.setUploadFileName(fileName);
				uf.setUploadRealName(realName);

				uploadFiles.add(uf);

				// uploadRealName[i]=UUID.randomUUID().toString();
				// System.out.println("uploadRealName:"+uploadRealName[i]);
				// for(File file:upload)
				// {
				// System.out.println("filename:"+file.getName());
				// }
				// System.out.println("filename:"+fileName);
				// System.out.println("Ext:"+getExt(fileName));
				// System.out.println("Type:"+type);
				// System.out.println(target.getPath());
			}
			ServletActionContext.getRequest().setAttribute("uploadFiles",
					uploadFiles);

		} catch (Exception e)
		{
			e.printStackTrace();
			addActionError(e.getMessage());

			return INPUT;
		}

		return SUCCESS;

	}

	public File[] getUpload()
	{
		return upload;
	}

	public void setUpload(File[] upload)
	{
		this.upload = upload;
	}

	public String[] getUploadContentType()
	{
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName()
	{
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}

	public static String getExt(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf("."));
	}

}
