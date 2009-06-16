package com.bjsxt.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryUserAction implements Action {

	public String execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("---queryUser---");
		//取得表单数据
		String username = req.getParameter("username");
		UserManager userManager = new UserManager();
		List userList = userManager.findUserByName(username);
		req.setAttribute("userlist", userList);
		
		//转向到c.jsp，取出list中的数据
		//req.getRequestDispatcher("/a/b/c/c.jsp").forward(req, res);
		return "/a/b/c/c.jsp";
	}

}
