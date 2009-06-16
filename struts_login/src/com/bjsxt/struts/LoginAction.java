package com.bjsxt.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * �û���¼��Action
 * @author Administrator
 *
 */
public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginActionForm laf = (LoginActionForm)form;
		String username = laf.getUsername();
		String password = laf.getPassword();
//		if ("admin".equals(username) && "admin".equals(password)) {
//			//ת�򵽵�¼�ɹ�ҳ��
//			request.setAttribute("username", username);
//			return mapping.findForward("success");
//		}else {
//			//ת�򵽵�¼ʧ��ҳ��
//			return mapping.findForward("error");
//		}
		String errorInfo = "";
		try {
			UserManager.getInstance().login(username, password);
			//request.setAttribute("username", username);
			return mapping.findForward("success");
		}catch(UserNotFoundException unfe) {
			unfe.printStackTrace();
			errorInfo = "�û������ҵ����û�����=[" + username + "]";
		}catch(PasswordErrorException pee) {
			pee.printStackTrace();
			errorInfo = "�������";
		}
		request.setAttribute("errorinfo", errorInfo);
		return mapping.findForward("error");
	}

}
