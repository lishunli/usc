package com.bjsxt.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DynaActionForwardTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String page = request.getParameter("page");
//		ActionForward af = null;
//		if ("1".equals(page)) {
//			af = mapping.findForward("page1");
//		}else if ("2".equals(page)) {
//			af = mapping.findForward("page2");
//		}
//		return af;
		ActionForward af = new ActionForward();
		af.setPath("/page" + page + ".jsp?name=Tom");
		return af;
	}

}
