package cn.itcast.web.action.privilege;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.struts.DelegatingRequestProcessor;

import cn.itcast.bean.privilege.Employee;
import cn.itcast.bean.privilege.PrivilegeGroup;
import cn.itcast.bean.privilege.SystemPrivilege;
import cn.itcast.bean.privilege.SystemPrivilegePK;
import cn.itcast.utils.SiteUrl;
import cn.itcast.utils.WebUtil;

public class PermissionProcessor extends DelegatingRequestProcessor {

	@Override
	protected ActionForward processActionPerform(HttpServletRequest request,
			HttpServletResponse response, Action action, ActionForm form,
			ActionMapping mapping) throws IOException, ServletException {
		if(validate(request, action, mapping)){//У���û��Ƿ���Ȩ��
			return super.processActionPerform(request, response, action, form, mapping);
		}
		request.setAttribute("message", "��û��Ȩ��ִ�иò���");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.control.right"));
		return mapping.findForward("message");
	}
	/**
	 * У���û��Ƿ����ִ�е�ǰ������Ȩ��
	 */
	private boolean validate(HttpServletRequest request, Action action, ActionMapping mapping) {
		Method currentMethod = getCurrentMethod(request, action, mapping);//�õ���ǰִ�е�action����
		if(currentMethod!=null && currentMethod.isAnnotationPresent(Permission.class)){
			Permission permission = currentMethod.getAnnotation(Permission.class);
			SystemPrivilege privilege = new SystemPrivilege(new SystemPrivilegePK(permission.model(), permission.privilegeValue()));
			Employee employee = WebUtil.getEmployee(request);
			for(PrivilegeGroup p : employee.getGroups()){
				if(p.getPrivileges().contains(privilege)) return true;
			}
			return false;
		}
		return true;
	}
	/**
	 * �õ���ǰִ�еķ���
	 */
	private Method getCurrentMethod(HttpServletRequest request, Action action, ActionMapping mapping) {
		String methodName = "execute";
		if(DispatchAction.class.isAssignableFrom(action.getClass())){//�ж�DispatchAction�Ƿ���action�ĸ���
			methodName = request.getParameter(mapping.getParameter());
		}
		try {
			return  action.getClass().getMethod(methodName, ActionMapping.class, ActionForm.class,
				HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {}
		return null;
	}

}
