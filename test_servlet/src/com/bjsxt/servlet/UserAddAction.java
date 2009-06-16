package com.bjsxt.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAddAction implements Action {

	public String execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("------------------addUser--------------------");
		return "/add_success.jsp";
	}

}
