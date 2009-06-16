package com.bjsxt.struts;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * ÉÏ´«Action
 * @author Administrator
 *
 */
public class UploadTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadActionForm uaf = (UploadActionForm)form;
		System.out.println("title" + uaf.getTitle());
		FormFile myFile = uaf.getMyfile();
		if (myFile != null) {
			System.out.println("fileName=" + myFile.getFileName());
			
			FileOutputStream fos = new FileOutputStream("c:\\" + myFile.getFileName());
			fos.write(myFile.getFileData());
			fos.flush();
			fos.close();
		}
		return mapping.findForward("success");
	}

}
