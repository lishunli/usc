/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.yourcompany.struts.form.IndexForm;

public class IndexAction extends DispatchAction {

	public ActionForward A(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		IndexForm indexForm = (IndexForm) form;
		System.out.println("A方法的调用");
		System.out.println(indexForm.getUname()+"   "+indexForm.getUpass());
		return null;
	}

	public ActionForward B(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		IndexForm indexForm = (IndexForm) form;
		System.out.println("B方法的调用");
		System.out.println(indexForm.getUname()+"   "+indexForm.getUpass());
		return null;
	}
}