/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.usc.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 06-18-2009
 * 
 * XDoclet definition:
 * @struts.form name="searchbynoForm"
 */
public class SearchbynoForm extends ActionForm
{
	/*
	 * Generated fields
	 */

	/** ѧ�� property */
	private String sno;

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
			HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the sno.
	 * @return String
	 */
	public String getsno()
	{
		return sno;
	}

	/** 
	 * Set the sno.
	 * @param sno The sno to set
	 */
	public void setsno(String sno)
	{
		this.sno = sno;
	}
}