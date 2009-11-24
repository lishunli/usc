package cn.itcast.web.action.privilege;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.privilege.Department;
import cn.itcast.bean.privilege.Employee;
import cn.itcast.bean.privilege.IDCard;
import cn.itcast.bean.privilege.PrivilegeGroup;
import cn.itcast.bean.user.Gender;
import cn.itcast.service.privilege.DepartmentService;
import cn.itcast.service.privilege.EmployeeService;
import cn.itcast.service.privilege.PrivilegeGroupService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.privilege.EmployeeForm;
/**
 * Ա����Ϣά��
 */
@Controller("/control/employee/manage")
public class EmployeeManageAction extends DispatchAction {
	@Resource EmployeeService employeeService;
	@Resource DepartmentService departmentService;
	@Resource PrivilegeGroupService groupService;
	
	
	/**
	 * Ȩ�����ý���
	 */
	@Permission(model="employee", privilegeValue="privilegeGroupSet")
	public ActionForward privilegeGroupSetUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		request.setAttribute("groups", groupService.getScrollData().getResultlist());
		Employee employee = employeeService.find(formbean.getUsername().trim());
		request.setAttribute("usergroups", employee.getGroups());
		return mapping.findForward("privilegeSet");
	}
	/**
	 * Ȩ������
	 */
	@Permission(model="employee", privilegeValue="privilegeGroupSet")
	public ActionForward privilegeGroupSet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		Employee employee = employeeService.find(formbean.getUsername().trim());
		employee.getGroups().clear();
		if(formbean.getGroupids()!=null){
			for(Integer id : formbean.getGroupids()){
				employee.addPrivilegeGroup(new PrivilegeGroup(id));
			}
		}
		employeeService.update(employee);
		
		request.setAttribute("message", "���óɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		return mapping.findForward("message");
	}
	
	/**
	 * ���Ա������
	 */
	@Permission(model="employee", privilegeValue="reg")
	public ActionForward regEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//1>��ȡ���еĲ����б��Ž���request��Χ,keyΪdepartments
		EmployeeForm formbean = (EmployeeForm) form;
		formbean.setGender(Gender.MAN);
		request.setAttribute("departments", departmentService.getScrollData().getResultlist());
		return mapping.findForward("addEmployee");
	}
	
	/**
	 * ���Ա��
	 */
	@Permission(model="employee", privilegeValue="reg")
	public ActionForward regEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		if(!this.employeeService.exist(formbean.getUsername().trim())){
			Employee employee = new Employee(formbean.getUsername().trim());
			employee.setDegree(formbean.getDegree());
			if(formbean.getDepartmentid()!=null && formbean.getDepartmentid()>0)
				employee.setDepartment(new Department(formbean.getDepartmentid()));
			employee.setEmail(formbean.getEmail());
			employee.setGender(formbean.getGender());
			employee.setIdCard(new IDCard(formbean.getCardno(), formbean.getAddress(), formbean.getBirthday()));
			employee.setPassword(formbean.getPassword());
			employee.setPhone(formbean.getPhone());
			employee.setRealname(formbean.getRealname());
			employee.setSchool(formbean.getSchool());
			if(formbean.getPicture()!=null && formbean.getPicture().getFileSize()>0 &&
					EmployeeForm.validateImageFileType(formbean.getPicture())){
				String imageName = UUID.randomUUID().toString()+ "."+ EmployeeForm.getExt(formbean.getPicture());
				String strDir = "/images/employee/"+ employee.getUsername();
				File saveDir = new File(request.getSession().getServletContext().getRealPath(strDir));
				EmployeeForm.saveFile(saveDir, imageName, formbean.getPicture().getFileData());
				employee.setImageName(imageName);
			}
			employeeService.save(employee);
			
			request.setAttribute("message", "���Ա���ɹ�");
			request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		}else{
			request.setAttribute("message", "���û����Ѿ�����");
			request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.addUI"));
		}
		//1>�ж��û����Ƿ����,�������,��ʾ"���û����Ѿ�����",����ִ�����沽��
		//2>��ȡ�����������Employee�����IDCard����,��IDCard����Employee����
		//3>����û��ϴ�����Ƭ,����֤��Ƭ�Ƿ���ͼƬ��ʽ( formbean.validateImageFileType(formfile) ),�����ͼƬ��ʽ�Ű���Ƭ������/images/employee/�û��˺�/·����.������ļ�������UUID����.
		//4>���ļ��������ý�Employee����.
		//5>����ҵ��bean����Employee����
		return mapping.findForward("message");
	}
	/**
	 * ��־Ա����ְ
	 */
	@Permission(model="employee", privilegeValue="leave")
	public ActionForward leave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		employeeService.leave(formbean.getUsername());
		
		request.setAttribute("message", "���óɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		return mapping.findForward("message");
	}
	
	/**
	 * Ա����Ϣ�޸Ľ���
	 */
	@Permission(model="employee", privilegeValue="update")
	public ActionForward editEmployeeUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		Employee employee = employeeService.find(formbean.getUsername().trim());
		
		formbean.setDegree(employee.getDegree());
		formbean.setEmail(employee.getEmail());
		formbean.setGender(employee.getGender());
		if(employee.getDepartment()!=null)
			formbean.setDepartmentid(employee.getDepartment().getId());
		formbean.setCardno(employee.getIdCard().getCardno());
		formbean.setAddress(employee.getIdCard().getAddress());
		formbean.setBirthday(employee.getIdCard().getBirthday());
		formbean.setPassword(employee.getPassword());
		formbean.setPhone(employee.getPhone());
		formbean.setRealname(employee.getRealname());
		formbean.setSchool(employee.getSchool());
		
	 	request.setAttribute("departments", departmentService.getScrollData().getResultlist());
	 	request.setAttribute("selectdepartmentid", employee.getDepartment().getId());
	 	request.setAttribute("imagePath", employee.getImageFullpath());
		return mapping.findForward("editEmployee");
	}
	/**
	 * �޸�Ա����Ϣ
	 */
	@Permission(model="employee", privilegeValue="update")
	public ActionForward editEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		Employee employee = employeeService.find(formbean.getUsername().trim());
		employee.setDegree(formbean.getDegree());
		employee.setDepartment(new Department(formbean.getDepartmentid()));
		employee.setEmail(formbean.getEmail());
		employee.setGender(formbean.getGender());
		employee.getIdCard().setCardno(formbean.getCardno());
		employee.getIdCard().setAddress(formbean.getAddress());
		employee.getIdCard().setBirthday(formbean.getBirthday());
		employee.setPhone(formbean.getPhone());
		employee.setRealname(formbean.getRealname());
		employee.setSchool(formbean.getSchool());
		if(formbean.getPicture()!=null && formbean.getPicture().getFileSize()>0 &&
				EmployeeForm.validateImageFileType(formbean.getPicture())){
			String imageName = UUID.randomUUID().toString()+ "."+ EmployeeForm.getExt(formbean.getPicture());
			String strDir = "/images/employee/"+ employee.getUsername();
			File saveDir = new File(request.getSession().getServletContext().getRealPath(strDir));
			EmployeeForm.saveFile(saveDir, imageName, formbean.getPicture().getFileData());
			employee.setImageName(imageName);
		}
		employeeService.update(employee);
		
		request.setAttribute("message", "�޸�Ա����Ϣ�ɹ�");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		return mapping.findForward("message");
	}
	/**
	 * У���û����Ƿ����
	 */
	public ActionForward exist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		if(employeeService.exist(formbean.getUsername().trim())){
			request.setAttribute("message", "�û��Ѿ�����");
		}else{
			request.setAttribute("message", "���û�������ʹ��");
		}
		return mapping.findForward("usernameIsExsit");
	}
	
	
}
