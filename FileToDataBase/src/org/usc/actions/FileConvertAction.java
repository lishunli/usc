package org.usc.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.usc.beans.UploadFiles;
import org.usc.services.FileConvert;
import org.usc.utils.UploadConfigurationRead;

import com.opensymphony.xwork2.ActionSupport;

public class FileConvertAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileConvert fileConvert;

	public void setFileConvert(FileConvert fileConvert)
	{
		this.fileConvert = fileConvert;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception
	{
		boolean result = false;
		String targetDirectory = ServletActionContext
				.getServletContext()
				.getRealPath(
						"/"
								+ UploadConfigurationRead.getInstance()
										.getConfigItem("uploadFilePath").trim());// 获得路径

		List<UploadFiles> UploadFiles = (List<UploadFiles>) ServletActionContext
				.getRequest().getAttribute("uploadFiles");// 获取上传的文件

		for (UploadFiles UploadFile : UploadFiles)
		{
//			System.out.println(UploadFile.getUploadFileName() + ":"
//					+ UploadFile.getUploadRealName());
//			System.out.println(targetDirectory + "\\"
//					+ UploadFile.getUploadRealName());
			result = fileConvert.fileConvert(targetDirectory + "\\"
					+ UploadFile.getUploadRealName());
		}
		
		
		
		if (result)
			return SUCCESS;
		else
			return INPUT;
	}
}
