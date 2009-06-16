package com.bjsxt.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

public class LoginAction extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
		DynaValidatorForm loginForm = (DynaValidatorForm)form;
		String username = (String)loginForm.get("username");
		String password = (String)loginForm.get("password");
		
		return mapping.findForward("success");
	}

}
