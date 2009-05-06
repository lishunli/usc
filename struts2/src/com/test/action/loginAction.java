package com.test.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.exception.PasswordException;
import com.test.exception.UsernameException;
import com.test.service.LoginService;


@SuppressWarnings("serial")
//public class loginAction extends ActionSupport implements ServletRequestAware
//public class loginAction extends ActionSupport implements ServletResponseAware
public class loginAction extends ActionSupport
{
	private String username;
	private String password;
	private LoginService loginService;
	
//	private HttpServletResponse response;
//	private HttpServletRequest request;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
//	@SuppressWarnings("unchecked")
//	public String log() throws Exception
//	{
//		System.out.println("log invoked");
//
//		if ("hello".equals(this.getUsername().trim())
//				&& "world".equals(this.getPassword().trim()))
//		{
//			Map map=ActionContext.getContext().getSession();
//			map.put("user", "valid");
////			HttpServletResponse response = ServletActionContext.getResponse();
////			
////			 Cookie cookie = new Cookie("username",this.getUsername());
////			 cookie.setMaxAge(1000);
////			 response.addCookie(cookie);
//			
//			return "success";
//		}
//		else
//		{
//			this.addFieldError("username", "username or password error");
//			return "failer";
//		}
//
//	}
	

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		if (loginService.isLogin(username, password))
		{
			return SUCCESS;
		}
		else
		{
			return INPUT;
		}
		
		
//		异常处理
//		空指针异常，好的习惯，就是把常量放在equals前面	
//		if (!"hello".equals(this.getUsername().trim()))
//		{
//			throw new UsernameException("username  invalid");
//		}
//		else if(!"world".equals(this.getPassword().trim()))
//		{
//			throw new PasswordException("password invalid");
//			
//		}
//		else return SUCCESS;
		
		
		
//		if ("hello".equals(this.getUsername().trim())
//				&& "world".equals(this.getPassword().trim()))
//		{
//			Map map=ActionContext.getContext().getSession();
//			map.put("user", "valid");
//			
////			如果采用action与servlet耦合的话，
////			首选ActionContext,
////			第二选HttpServletResponse，
////			最后选接口的（一般不要使用）ServletResponseAware，ServletRequestAware
//			
//			
//			
////			ActionContext.getContext().put("zhangsan","helloworld");//类似于setAttribute
////			request.setAttribute("zhangsan","helloworld");
//			
////			HttpServletResponse response = ServletActionContext.getResponse();
////			
////			 Cookie cookie = new Cookie("username",this.getUsername());
////			 cookie.setMaxAge(1000);
////			 response.addCookie(cookie);
////			
//			return "success";
//		}
//		else
//		{
//			this.addFieldError("username", "username or password error");
//			return "failer";
//		}

	}
//	@Override
//	public void validate() {
//		if (null == this.getUsername() || "".equals(this.getUsername().trim()))
//		{
//			this.addFieldError("username", "username required");
//		}
//		if (null == this.getPassword() || "".equals(this.getPassword().trim()))
//		{
//			this.addFieldError("password", "password required");
//		}
//	}
//	public void setServletRequest(HttpServletRequest arg0) {
//		 System.out.println("request");
//		 this.request = arg0;
//		
//	}
//	public void setServletResponse(HttpServletResponse arg0) {
//		this.response=arg0;
//	}
	

	
	

}
