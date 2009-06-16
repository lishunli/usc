package com.bjsxt.drp.web.usermgr.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.drp.business.usermgr.manager.UserManager;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.web.usermgr.forms.UserActionForm;

/**
 * �޸��û�Action
 *
 */
public class ModifyUserAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡ��ҳ������ύ������ֵ
		UserActionForm uaf = (UserActionForm)form;
		
//		//����Userʵ����󣬲���ActionForm�е��������õ�User������
//		User user = new User();
//		user.setUserId(uaf.getUserId());
//		user.setUserName(uaf.getUserName());
//		user.setPassword(uaf.getPassword());
//		user.setEmail(uaf.getEmail());
//		user.setContactTel(uaf.getContactTel());
//		user.setCreateDate(new Date());
		
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		
		//����ҵ���߼�����
		UserManager.getInstance().modifyUser(user);
		
		return mapping.findForward("success");
	}
}