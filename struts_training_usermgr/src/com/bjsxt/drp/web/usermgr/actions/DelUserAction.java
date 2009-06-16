package com.bjsxt.drp.web.usermgr.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * �û�ɾ��Action
 *
 */
public class DelUserAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
		//ȡ����Ҫɾ����userId�ļ���
		String[] userIdList = uaf.getSelectFlag();

		//����ҵ���߼�����
		UserManager.getInstance().deleteUsers(userIdList);
		return mapping.findForward("success");
	}
	
}