package com.bjsxt.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryUserAction implements Action {

	public String execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("---queryUser---");
		//ȡ�ñ�����
		String username = req.getParameter("username");
		UserManager userManager = new UserManager();
		List userList = userManager.findUserByName(username);
		req.setAttribute("userlist", userList);
		
		//ת��c.jsp��ȡ��list�е�����
		//req.getRequestDispatcher("/a/b/c/c.jsp").forward(req, res);
		return "/a/b/c/c.jsp";
	}

}
