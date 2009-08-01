package com.usc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CheckUser extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ServletContext servletContext = request.getSession()
				.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		UsersManager um = (UsersManager) ctx.getBean("UserManager");

		// System.out.println("doget");
		try
		{

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			// 1.取参数
			String old = request.getParameter("name");
			// String name = new String(old.getBytes("iso8859-1"),"UTF-8");
			String name = URLDecoder.decode(old, "UTF-8");

			// if(null == um)
			// System.out.println("null");
			// else
			// System.out.println(um.checkUserName(name));

			// 2.检查参数是否有问题
			if (null != name && !um.checkUserName(name))

			{
//				System.out.println("exist");
				// 4。和传统应用不同之处。这一步需要将用户感兴趣的数据返回给页面段，而不是将一个新的页面发送给用户
				// 写法没有变化，本质发生了改变

				out.println("username exist,please change username");
			}
			// else
			// {
			// out.println("username not exist,you can use it");
			// }
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);

	}

}
