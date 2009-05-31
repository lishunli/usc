package com.bjsxt.usermgr.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.usermgr.forms.LoginActionForm;
import com.bjsxt.usermgr.manager.UserManager;

public class LoginAction extends Action {

	private UserManager userManager;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginActionForm laf = (LoginActionForm)form;
		
		userManager.login(laf.getUsername(), laf.getPassword());
		
		return mapping.findForward("success");
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
