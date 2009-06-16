/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.usc.struts.action;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.usc.struts.form.LoginForm;

/** 
 * MyEclipse Struts
 * Creation date: 06-15-2009
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" input="/login.jsp" scope="request" validate="true"
 */
public class LoginAction extends Action
{
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
//		System.out.println("execute");
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		List sex = new ArrayList();
		sex.add("nan");
//		return null;
////		1.方法一
//		return new ActionForward("/index.jsp");
		
//		2.方法二
		try
		{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
//		3.方法三
//		return mapping.findForward("success");
		
		
	}
}