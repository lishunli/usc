/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.usc.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.usc.manager.userManager;
import com.usc.manager.userManagerImpl;
import com.usc.struts.form.RegForm;
import com.usc.util.User;

/**
 * MyEclipse Struts Creation date: 06-07-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/reg" name="regForm" input="/reg.jsp" scope="request"
 *                validate="true"
 */
public class RegAction extends Action
{
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	private userManager um;

	public void setUm(userManager um)
	{
		this.um = um;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{

		RegForm regForm = (RegForm) form;// TODO Auto-generated method stub
		User user = new User();
		user.setUsename(regForm.getUsername());
		user.setPassword(regForm.getPassword());
		if (null == regForm.getUsername()
				|| "".equals(regForm.getUsername().trim())
				|| null == regForm.getPassword()
				|| "".equals(regForm.getPassword().trim()))
		{
			return new ActionForward("/usererror.jsp");// �û���������Ϊ�գ�
		} else if (!regForm.getPassword().trim().equals(
				regForm.getRepassword().trim()))
		{
			return new ActionForward("/confirmerror.jsp");// ������ظ����벻��ͬ��
		} else if(!um.checkusername(user))
		{
			return new ActionForward("/userexisterror.jsp");//  �û��Ѵ���
		}
		else
		{
			um.addUser(user);//�ɹ�ע��
			return mapping.findForward("regsuccess");
		}

	}
}