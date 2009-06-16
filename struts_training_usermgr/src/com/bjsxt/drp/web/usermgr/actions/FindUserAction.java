package com.bjsxt.drp.web.usermgr.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * ����ID��ѯ�û�Action
 *
 */
public class FindUserAction  extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
		String userId = uaf.getUserId();
		
		//����ҵ���߼�����
		User user = UserManager.getInstance().findUserById(userId);
		
		//��user�����Action���ݵ�JSPҳ��
		request.setAttribute("user", user);
		
		return mapping.findForward("success");
	}
	
}