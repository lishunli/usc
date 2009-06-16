package com.bjsxt.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 用户登录的Action
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
//			//转向到登录成功页面
//			request.setAttribute("username", username);
//			return mapping.findForward("success");
//		}else {
//			//转向到登录失败页面
//			return mapping.findForward("error");
//		}
		String errorInfo = "";
		try {
			UserManager.getInstance().login(username, password);
			//request.setAttribute("username", username);
			return mapping.findForward("success");
		}catch(UserNotFoundException unfe) {
			unfe.printStackTrace();
			errorInfo = "用户不能找到，用户名称=[" + username + "]";
		}catch(PasswordErrorException pee) {
			pee.printStackTrace();
			errorInfo = "密码错误";
		}
		request.setAttribute("errorinfo", errorInfo);
		return mapping.findForward("error");
	}

}
