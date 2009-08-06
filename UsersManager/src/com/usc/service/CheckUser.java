package com.usc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
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

		try
		{

			response.setContentType("text/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<message>");

			// out.println("<verifycodemes>" + "verifycode is error" +
			// "</verifycodemes>");

			// 1.取参数
			String old = request.getParameter("name");
			if (old != null) // 不是检查username，是检测后面非空的字段
			{
				// String name = new String(old.getBytes("iso8859-1"),"UTF-8");
				String name = URLDecoder.decode(old, "UTF-8");

				// if(null == um)
				// System.out.println("null");
				// else
				// System.out.println(um.checkUserName(name));

				// 2.检查参数是否有问题
				if (!um.checkUserName(name))

				{
					out.println("<usernamemes>"
							+ "username exist,please change username"
							+ "</usernamemes>");
					// System.out.println("exist");
					// 4。和传统应用不同之处。这一步需要将用户感兴趣的数据返回给页面段，而不是将一个新的页面发送给用户
					// 写法没有变化，本质发生了改变

					// out.println("username exist,please change username");
				} else
				{
					out.println("<usernamemes>"
							+ "username not exist,you can use it"
							+ "</usernamemes>");
					// out.println("username not exist,you can use it");
				}
			} else
			{
				out.println("<usernamemes>" + "username is required"
						+ "</usernamemes>");
			}
			String verifycodeold = request.getParameter("verify");
//			System.out.println("verifycodeold" + verifycodeold);
			if (verifycodeold != null)// 不是检查verifycode，是检测后面非空的字段
			{
				String verifycode = URLDecoder.decode(verifycodeold, "UTF-8");
//				System.out.println("verifycode" + verifycode);
				if (verifycode != null
						&& !verifycode.equalsIgnoreCase((String) request
								.getSession().getAttribute("verify")))
				{

//					System.out.println("error");
					out.println("<verifycodemes>" + "verifycode is error"
							+ "</verifycodemes>");
				}
			} else
			{
				out.println("<verifycodemes>" + "verifycode is required"
						+ "</verifycodemes>");
			}

			out.println("</message>");
			out.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * out.println("<message>"); if(uname.equals("jenny") && psw.equals("hi")){
	 * out.println("<res>" + "热烈的欢迎您!" + "</res>"); }else{ out.println("<res>" +
	 * "对不起,登录失败！" + "</res>"); } out.println("</message>"); out.close();
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);

	}

}
