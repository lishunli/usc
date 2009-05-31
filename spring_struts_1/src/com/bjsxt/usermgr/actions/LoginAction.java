package com.bjsxt.usermgr.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.usermgr.forms.LoginActionForm;
import com.bjsxt.usermgr.manager.UserManager;
import com.bjsxt.usermgr.manager.UserManagerImpl;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginActionForm laf = (LoginActionForm)form;
	
////		1.ֱ��ʹ�ã�û��ʹ��spring
//		UserManager userManager = new UserManagerImpl();
//		userManager.login(laf.getUsername(), laf.getPassword());
	
////		2.ʹ��spring���������Ĺ���
//		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-beans.xml");
//		UserManager userManager = (UserManager)factory.getBean("userManager");
//		userManager.login(laf.getUsername(), laf.getPassword());
		
//			3.ʹ��web.xml������listener����ȡ�����ļ�����������
		BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		
		//ApplicationContext�̳�beanfactory�����Բ���ǿ��ת����Ҳ����ʹ������Ļ����
		//ApplicationContext pc = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		UserManager userManager = (UserManager)factory.getBean("userManager");
		userManager.login(laf.getUsername(), laf.getPassword());
		
		return mapping.findForward("success");
	}

	
}
