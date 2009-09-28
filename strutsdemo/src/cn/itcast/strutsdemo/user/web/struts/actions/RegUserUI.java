package cn.itcast.strutsdemo.user.web.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.itcast.strutsdemo.user.domain.Gender;
import cn.itcast.strutsdemo.user.domain.Sex;
import cn.itcast.strutsdemo.user.domain.Speciality;

public class RegUserUI extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//return new ActionForward("/WEB-INF/user/reguser.jsp");
		System.out.println(request.getClass());
		this.saveToken(request);
		request.setAttribute("specialities", getSpecialities());
		//request.setAttribute("genders", Gender.values());
		request.setAttribute(
				"genders", 
				new Sex[]{
						new Sex("MAN","男"),
						new Sex("WOMAN","女"),
						new Sex("BOTH","男女均可"),						
				}
		);
		//return mapping.findForward("success");
		return mapping.findForward("xxx");
	}
	
	private Speciality[] getSpecialities()
	{
		return new Speciality[]{
				new Speciality(1,"football"),
				new Speciality(2,"basketball"),
				new Speciality(3,"ping-pong"),				
				new Speciality(4,"volleyball"),
				new Speciality(5,"baseball"),
				new Speciality(6,"tennis ball")					
		};

	}
	
}
