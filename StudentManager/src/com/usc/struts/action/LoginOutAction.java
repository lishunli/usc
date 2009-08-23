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

/** 
 * MyEclipse Struts
 * Creation date: 06-17-2009
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class LoginOutAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("login");
		return mapping.findForward("success");
	}
}