package org.usc.actions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.beans.User;
import org.usc.services.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Access : get-all-user.action
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-13<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */

@Controller
@Scope("prototype")
@Results( { @Result(name = "success", location = "allUser.jsp"), @Result(name = "input", location = "/index.jsp") })
public class GetAllUserAction extends ActionSupport {

	private static final long serialVersionUID = 7958465618288847607L;

	private List<User> userList;

	@Resource(name = "org.usc.services.userService")
	private IUserService userService;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void validate() {
	}

	@Override
	public String execute() throws Exception {
		userList = userService.getScrollData().getResultList();

		return SUCCESS;
	}

}
