package com.bjsxt.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 * ≤‚ ‘∂ØÃ¨ActionForm
 * @author Administrator
 *
 */
public class DynaActionFormTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm daf = (DynaActionForm)form;
		String username = (String)daf.get("username");
		Integer age = (Integer)daf.get("age");
		System.out.println("username=" + username);
		System.out.println("age=" + age);
		return mapping.findForward("success");
	}

}
