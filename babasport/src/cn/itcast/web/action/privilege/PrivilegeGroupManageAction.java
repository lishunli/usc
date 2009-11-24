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

import cn.itcast.bean.privilege.PrivilegeGroup;
import cn.itcast.bean.privilege.SystemPrivilege;
import cn.itcast.bean.privilege.SystemPrivilegePK;
import cn.itcast.service.privilege.PrivilegeGroupService;
import cn.itcast.service.privilege.SystemPrivilegeService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.privilege.PrivilegeGroupForm;

@Controller("/control/privilegegroup/manage")
public class PrivilegeGroupManageAction extends DispatchAction {
	@Resource PrivilegeGroupService groupService;
	@Resource SystemPrivilegeService privilegeService;
	
	/**
	 * ɾ��Ȩ����
	 */
	@Permission(model="privilegeGroup", privilegeValue="delete")
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrivilegeGroupForm formbean = (PrivilegeGroupForm) form;
		groupService.delete((Serializable)formbean.getGroupid());

		request.setAttribute("message", "ɾ��Ȩ����ɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.privilegegroup.list"));
		return mapping.findForward("message");
	}
	/**
	 * Ȩ������ӽ���
	 */
	@Permission(model="privilegeGroup", privilegeValue="insert")
	public ActionForward addUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//�õ����е�ϵͳȨ��,��Ž�request��Χ,keyΪprivileges
		request.setAttribute("privileges", privilegeService.getScrollData().getResultlist());
		return mapping.findForward("addprivilegegroup");
	}
	
	/**
	 * ���Ȩ����
	 */
	@Permission(model="privilegeGroup", privilegeValue="insert")
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrivilegeGroupForm formbean = (PrivilegeGroupForm) form;
		PrivilegeGroup group = new PrivilegeGroup();
		group.setName(formbean.getName());
		for(SystemPrivilegePK id : formbean.getPrivileges()){
			group.addPrivilege(new SystemPrivilege(id));
		}
		groupService.save(group);
		request.setAttribute("message", "���Ȩ����ɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.privilegegroup.list"));
		return mapping.findForward("message");
	}
	
	/**
	 * Ȩ�����޸Ľ���
	 */
	@Permission(model="privilegeGroup", privilegeValue="update")
	public ActionForward editUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrivilegeGroupForm formbean = (PrivilegeGroupForm) form;
		PrivilegeGroup group = groupService.find(formbean.getGroupid());
		formbean.setName(group.getName());
		request.setAttribute("privileges", privilegeService.getScrollData().getResultlist());
		request.setAttribute("selectprivileges", group.getPrivileges());
		return mapping.findForward("editprivilegegroup");
	}
	/**
	 * �޸�Ȩ����
	 */
	@Permission(model="privilegeGroup", privilegeValue="update")
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrivilegeGroupForm formbean = (PrivilegeGroupForm) form;
		PrivilegeGroup group = groupService.find(formbean.getGroupid());
		group.setName(formbean.getName());
		group.getPrivileges().clear();
		for(SystemPrivilegePK id : formbean.getPrivileges()){
			group.addPrivilege(new SystemPrivilege(id));
		}
		groupService.update(group);
		
		request.setAttribute("message", "�޸�Ȩ����ɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.privilegegroup.list"));
		return mapping.findForward("message");
	}
	
}
