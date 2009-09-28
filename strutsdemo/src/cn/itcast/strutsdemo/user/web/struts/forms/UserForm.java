package cn.itcast.strutsdemo.user.web.struts.forms;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.RequestUtils;

import cn.itcast.strutsdemo.user.domain.Gender;
import cn.itcast.strutsdemo.user.domain.User;

public class UserForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean autoLogon;
	private String password2;
	private User user = new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	} 
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();	
		if(getUser().getPhoto() == null)
		{
			errors.add("xxx", new ActionMessage("file too big",false));
			return errors;			
		}


		if("".equals(user.getUsername().trim()))
		{
			MessageResources resources = ((MessageResources) request.getAttribute(Globals.MESSAGES_KEY));
			Locale locale = RequestUtils.getUserLocale(request, null);
			errors.add("username", new ActionMessage("error.username",resources.getMessage(locale,"prompt.username")));
		}
		if(!user.getPassword().equals(password2))
		{
			errors.add("password2", new ActionMessage("error.password2"));
			
		}
		return errors;
	}
	public boolean isAutoLogon() {
		return autoLogon;
	}
	public void setAutoLogon(boolean autoLogon) {
		this.autoLogon = autoLogon;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		autoLogon = false;
		super.reset(mapping, request);
	}

}
