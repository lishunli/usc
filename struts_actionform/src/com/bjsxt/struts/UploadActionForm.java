package com.bjsxt.struts;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * �ϴ�ActionForm
 * @author Administrator
 *
 */
public class UploadActionForm extends ActionForm {

	private String title;
	
	//�������FormFile
	private FormFile myfile;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public FormFile getMyfile() {
		return myfile;
	}

	public void setMyfile(FormFile myfile) {
		this.myfile = myfile;
	}
}
