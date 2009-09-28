package cn.itcast.strutsdemo.user.web.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/*模板方法设计模式*/
public abstract class ItcastBaseAction extends Action {

	public ItcastBaseAction() {
		super();
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				// TODO Auto-generated method stub
				try
				{
					return doExecute(mapping, form, request, response);
				}
				catch(Exception e)
				{
					System.out.println("发短信" + e.getMessage());
					response.getWriter().print("system is upgrading!!!,try again later");
					return null;
				}
			
			}
	
	protected abstract ActionForward doExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}