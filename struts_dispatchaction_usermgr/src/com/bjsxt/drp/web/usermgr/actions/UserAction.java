package com.bjsxt.drp.web.usermgr.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * �û�CRUD
 * @author Administrator
 *
 */
public class UserAction extends DispatchAction {

	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("-----------UserAction.unspecified()-----------");
		
		//����ҵ���߼�����
		List userList = UserManager.getInstance().findAllUserList();
		request.setAttribute("userlist", userList);
		
		return mapping.findForward("list_success");
		
//		ActionForward af = new ActionForward();
//		af.setPath("/user/usermaint.do?command=list");
//		af.setRedirect(true);
//		return af;
	}

	/**
	 * �û����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		
		//����ҵ���߼�����
		UserManager.getInstance().addUser(user);
		
		
		return mapping.findForward("success");
	}	
	
	/**
	 * �û�ɾ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
		//ȡ����Ҫɾ����userId�ļ���
		String[] userIdList = uaf.getSelectFlag();

		//����ҵ���߼�����
		UserManager.getInstance().deleteUsers(userIdList);
		return mapping.findForward("success");
	}
	
	/**
	 * ����ID��ѯ�û�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward find(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
		String userId = uaf.getUserId();
		
		//����ҵ���߼�����
		User user = UserManager.getInstance().findUserById(userId);
		
		//��user�����Action���ݵ�JSPҳ��
		request.setAttribute("user", user);
		
		return mapping.findForward("find_success");
	}
	
//	/**
//	 * ��ѯ�����û�
//	 * @param mapping
//	 * @param form
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward list(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		//����ҵ���߼�����
//		List userList = UserManager.getInstance().findAllUserList();
//		request.setAttribute("userlist", userList);
//		
//		return mapping.findForward("list_success");
//	}
	
	/**
	 * �޸��û�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		
		//����ҵ���߼�����
		UserManager.getInstance().modifyUser(user);
		
		return mapping.findForward("success");
	}
	
}
