package cn.itcast.web.action.privilege;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.service.privilege.DepartmentService;
/**
 * Ա����ѯ����
 */
@Controller("/control/employee/query")
public class EmployeeQueryAction extends Action {
	@Resource DepartmentService departmentService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ���еĲ���,Ȼ���QueryResult�еõ������б�,��Ž�request��Χ,keyΪdepartments
		request.setAttribute("departments", departmentService.getScrollData().getResultlist());
		return mapping.findForward("query");
	}

}
