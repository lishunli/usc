package cn.itcast.web.action.privilege;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.privilege.Department;
import cn.itcast.service.privilege.DepartmentService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.privilege.DepartmentForm;

@Controller("/control/department/manage")
public class DepartmentManageAction extends DispatchAction {
	@Resource DepartmentService departmentService;
	/**
	 * ������ӽ���
	 */
	@Permission(model="department", privilegeValue="insert")
	public ActionForward addDepartmentUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("adddepartment");
	}
	/**
	 * ��Ӳ���
	 */
	@Permission(model="department", privilegeValue="insert")
	public ActionForward addDepartment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DepartmentForm formbean = (DepartmentForm)form;
		departmentService.save(new Department(formbean.getName()));
		
		request.setAttribute("message", "��Ӳ��ųɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.department.list"));
		return mapping.findForward("message");
	}
	/**
	 * �����޸Ľ���
	 */
	@Permission(model="department", privilegeValue="update")
	public ActionForward editDepartmentUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DepartmentForm formbean = (DepartmentForm)form;
		Department department = departmentService.find(formbean.getDepartmentid());
		formbean.setName(department.getName());
		return mapping.findForward("editdepartment");
	}
	/**
	 * �޸Ĳ���
	 */
	@Permission(model="department", privilegeValue="update")
	public ActionForward editDepartment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DepartmentForm formbean = (DepartmentForm)form;
		Department department = departmentService.find(formbean.getDepartmentid());
		department.setName(formbean.getName());
		departmentService.update(department);
		
		request.setAttribute("message", "�޸Ĳ��ųɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.department.list"));
		return mapping.findForward("message");
	}
	
	/**
	 * ɾ������
	 */
	@Permission(model="department", privilegeValue="delete")
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DepartmentForm formbean = (DepartmentForm)form;
		departmentService.delete((Serializable)formbean.getDepartmentid());
		
		request.setAttribute("message", "ɾ�����ųɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.department.list"));
		return mapping.findForward("message");
	}
	
}
