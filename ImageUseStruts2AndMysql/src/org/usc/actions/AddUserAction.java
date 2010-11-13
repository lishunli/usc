package org.usc.actions;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.usc.beans.User;
import org.usc.services.IUserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Access : add-user.action
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-10<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */

@Controller
@Scope("prototype")
@Results( { @Result(name = "success", location = "/index.jsp"), @Result(name = "input", location = "addUser.jsp") })
@InterceptorRefs(value = {
		@InterceptorRef(value = "fileUpload", params = { "maximumSize", "1048576", "allowedTypes",
				"image/bmp,image/x-png,image/png,image/gif,image/jpeg,image/jpg,image/pjpeg" }), @InterceptorRef(value = "defaultStack") })
public class AddUserAction extends ActionSupport {
	private static final long serialVersionUID = -4829467290275994251L;

	private User user;
	private File image;

	@Resource(name = "org.usc.services.userService")
	private IUserService userService;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getImage() {
		return image;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void validate() {
		if (user == null) {
			this.addFieldError("user", "user is null");
		}
		else {
			if (user.getUsername() == null || "".equals(user.getUsername().trim())) {
				this.addFieldError("user.username", "username is null");
			}
			if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
				this.addFieldError("user.password", "password is null");
			}
		}

	}

	@Override
	public String execute() throws Exception {
		if (image != null) {
			FileInputStream fin = new FileInputStream(image);// File 转 InputStream
			Blob blob = Hibernate.createBlob(fin);// InputStream 转 Blob
			user.setPicture(blob);
		}

		userService.save(user);

		return SUCCESS;
	}
}
