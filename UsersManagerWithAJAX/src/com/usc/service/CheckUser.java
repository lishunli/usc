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
//	private UsersManager um;
	
//	@Override
//	public void init() throws ServletException
//	{
//		// TODO Auto-generated method stub
//		super.init();
////		ServletContext servletContext = this.getServletContext();   
////        
////        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);   
////                   
////        UsersManager um = (UsersManager) ctx.getBean("UserManager");  
//		ServletContext servletContext = this
//				.getServletContext();
//		ApplicationContext ctx = WebApplicationContextUtils
//				.getWebApplicationContext(servletContext);
//		UsersManager um = (UsersManager) ctx.getBean("UserManager");
//
//	}

//	@Override
//	public void init(ServletConfig config) throws ServletException
//	{
//		ServletContext sc=config.getServletContext(); 
//		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc); 
//		um = (UsersManager) context.getBean("UserManager");
//	}

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

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			// 1.ȡ����
			String old = request.getParameter("name");
			// String name = new String(old.getBytes("iso8859-1"),"UTF-8");
			String name = URLDecoder.decode(old, "UTF-8");

			// if(null == um)
			// System.out.println("null");
			// else
			// System.out.println(um.checkUserName(name));

			// 2.�������Ƿ�������
			if (!um.checkUserName(name))

			{
				// System.out.println("exist");
				// 4���ʹ�ͳӦ�ò�֮ͬ������һ����Ҫ���û�����Ȥ�����ݷ��ظ�ҳ��Σ������ǽ�һ���µ�ҳ�淢�͸��û�
				// д��û�б仯�����ʷ����˸ı�

				out.println("username exist,please change username");
			} 
			else
			{
				out.println("username not exist,you can use it");
			}
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