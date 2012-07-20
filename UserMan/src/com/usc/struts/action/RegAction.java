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

import com.usc.manager.usermanager;
import com.usc.manager.usermanagerImpl;
import com.usc.struts.form.RegForm;
import com.usc.util.Use;

/** 
 * MyEclipse Struts
 * Creation date: 06-06-2009
 * 
 * XDoclet definition:
 * @struts.action path="/reg" name="regForm" input="/reg.jsp" scope="request" validate="true"
 */
public class RegAction extends Action
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
	private usermanager um;
	
	public void setUm(usermanager um)
	{
		this.um = um;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		RegForm regForm = (RegForm) form;// TODO Auto-generated method stub
		Use u = new Use();
		u.setUsername(regForm.getUsername());
		u.setPassword(regForm.getPassword());
		um.addUser(u);
		
		return new ActionForward("/index.jsp");
		
	}
}