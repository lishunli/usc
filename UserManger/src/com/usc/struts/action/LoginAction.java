/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.usc.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.usc.manager.userManager;
import com.usc.struts.form.LoginForm;
import com.usc.struts.form.RegForm;
import com.usc.util.Users;

/**
 * MyEclipse Struts Creation date: 06-06-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/login" name="loginForm" input="/login.jsp"
 *                scope="request" validate="true"
 */
public class LoginAction extends Action
{
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */

	private userManager um;

	public void setUm(userManager um)
	{
		this.um = um;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method
			
		Users user = new Users();
		user.setUname(loginForm.getUname());
		user.setUpass(loginForm.getUpass());
		
		if (um.checkLogin(user))
		{
			return mapping.findForward("success");
			
		} else
		{
			return new ActionForward("/index.jsp");
		}

	}
}