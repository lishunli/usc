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
 * 用户CRUD
 * @author Administrator
 *
 */
public class UserAction extends DispatchAction {

	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("-----------UserAction.unspecified()-----------");
		
		//调用业务逻辑操作
		List userList = UserManager.getInstance().findAllUserList();
		request.setAttribute("userlist", userList);
		
		return mapping.findForward("list_success");
		
//		ActionForward af = new ActionForward();
//		af.setPath("/user/usermaint.do?command=list");
//		af.setRedirect(true);
//		return af;
	}

	/**
	 * 用户添加
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
		
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		
		//调用业务逻辑操作
		UserManager.getInstance().addUser(user);
		
		
		return mapping.findForward("success");
	}	
	
	/**
	 * 用户删除
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
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
		//取得需要删除的userId的集合
		String[] userIdList = uaf.getSelectFlag();

		//调用业务逻辑操作
		UserManager.getInstance().deleteUsers(userIdList);
		return mapping.findForward("success");
	}
	
	/**
	 * 根据ID查询用户
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
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
		String userId = uaf.getUserId();
		
		//调用业务逻辑操作
		User user = UserManager.getInstance().findUserById(userId);
		
		//将user对象从Action传递到JSP页面
		request.setAttribute("user", user);
		
		return mapping.findForward("find_success");
	}
	
//	/**
//	 * 查询所有用户
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
//		//调用业务逻辑操作
//		List userList = UserManager.getInstance().findAllUserList();
//		request.setAttribute("userlist", userList);
//		
//		return mapping.findForward("list_success");
//	}
	
	/**
	 * 修改用户
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
		//获取从页面表单中提交过来的值
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		
		//调用业务逻辑操作
		UserManager.getInstance().modifyUser(user);
		
		return mapping.findForward("success");
	}
	
}
