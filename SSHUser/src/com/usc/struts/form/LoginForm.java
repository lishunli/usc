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
 * Creation date: 06-07-2009
 * 
 * XDoclet definition:
 * @struts.form name="loginForm"
 */
public class LoginForm extends ActionForm
{
	/*
	 * Generated fields
	 */

	/** password property */
	private String password;

	/** username property */
	private String username;

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
	 * Returns the password.
	 * @return String
	 */
	public String getPassword()
	{
		return password;
	}

	/** 
	 * Set the password.
	 * @param password The password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/** 
	 * Returns the username.
	 * @return String
	 */
	public String getUsername()
	{
		return username;
	}

	/** 
	 * Set the username.
	 * @param username The username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
}