/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class IndexForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** panme property */
	private String panme;

	/** photo property */
	private FormFile  photo;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the panme.
	 * @return String
	 */
	public String getPanme() {
		return panme;
	}

	/** 
	 * Set the panme.
	 * @param panme The panme to set
	 */
	public void setPanme(String panme) {
		this.panme = panme;
	}

	public FormFile getPhoto() {
		return photo;
	}

	public void setPhoto(FormFile photo) {
		this.photo = photo;
	}

	/** 
	 * Returns the photo.
	 * @return String
	 */

}