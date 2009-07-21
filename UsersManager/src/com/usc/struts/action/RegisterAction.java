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

import com.sun.org.apache.bcel.internal.generic.RET;
import com.usc.dao.User;
import com.usc.service.UsersManager;
import com.usc.struts.form.RegisterForm;

/**
 * MyEclipse Struts Creation date: 06-26-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/register" name="registerForm" input="/register.jsp"
 *                scope="request" validate="true"
 */
public class RegisterAction extends Action
{
	private User u;
	private UsersManager um;

	public void setU(User u)
	{
		this.u = u;
	}

	public void setUm(UsersManager um)
	{
		this.um = um;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		RegisterForm registerForm = (RegisterForm) form;// TODO Auto-generated
		if (null == registerForm.getUsername()
				|| null == registerForm.getPassword()
				|| null == registerForm.getRepassword()
				|| 0 == registerForm.getUsername().trim().length()
				|| 0 == registerForm.getPassword().trim().length()
				|| 0 == registerForm.getRepassword().trim().length())
		{
			return mapping.findForward("input");
		}

		else if (registerForm.getPassword().trim().equals(
				registerForm.getRepassword().trim()))
		{
			u.setUsername(registerForm.getUsername().trim());
			u.setPassword(um.encoderByMd5(registerForm.getPassword().trim()));
			um.addUser(u);
			return mapping.findForward("success");
		}
		return mapping.findForward("input");
	}
}