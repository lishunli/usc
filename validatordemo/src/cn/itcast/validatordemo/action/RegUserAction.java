/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package cn.itcast.validatordemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import cn.itcast.validatordemo.form.UserForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-02-2009
 * 
 * XDoclet definition:
 * @struts.action path="/RegUser" name="userForm" input="/WEB-INF/page/reguser.jsp" parameter="xxx" scope="request" validate="true"
 * @struts.action-forward name="success" path="/WEB-INF/page/main.jsp"
 * @struts.action-forward name="failure" path="/WEB-INF/page/reguser.jsp"
 */
public class RegUserAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		if(mapping.getParameter().equals("true"))
		{
			
		}
		else
		{
			
		}
		return null;
	}
}