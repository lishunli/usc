package org.usc.actions;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.usc.actions.base.BaseActionSupport;
import org.usc.beans.User;
import org.usc.services.user.IUserService;

/**
 * Access please User : add-user.action
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-10<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */

@Results( { @Result(name = "success", location = "/index.jsp"), @Result(name = "input", location = "/index.jsp") })
public class AddUserAction extends BaseActionSupport
{
	private static final long serialVersionUID = -4829467290275994251L;

	@Resource(name = "org.usc.services.user.userService")
	private IUserService userService;

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public String execute() throws Exception
	{
		System.out.println("hello world");
		
		User user = new User("lishunli","lishunli");
		
		userService.save(user);
		
		return INPUT;
	}
}
