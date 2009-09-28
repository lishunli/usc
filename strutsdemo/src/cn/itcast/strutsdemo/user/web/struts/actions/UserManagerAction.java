package cn.itcast.strutsdemo.user.web.struts.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.actions.MappingDispatchAction;

public class UserManagerAction extends /*LookupDispatchAction*/DispatchAction/*MappingDispatchAction*/ {

	protected Map getKeyMethodMap() {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("button.submit", "addUser");
		return map;
	}
	

	
	
	public ActionForward addUserUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		response.getWriter().print("addUserUI");
		return null;
	}
	
	public ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		response.getWriter().print("addUser");		
		return null;
	}	
	
	public ActionForward EditUserUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		response.getWriter().print("EditUserUI");
		return null;
	}
	
	public ActionForward EditUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		response.getWriter().print("EditUser");		
		return null;
	}
	
	public ActionForward getUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		response.getWriter().print("getUser");
		return null;
	}
	
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		response.getWriter().print("deleteUser");		
		return null;
	}		
}
