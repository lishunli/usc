package com.usc.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.usc.daos.BookDAO;
import com.usc.daos.DigitalDAO;

public class ShowImage extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ServletContext servletContext = request.getSession()
				.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		BookDAO bookDao = (BookDAO) ctx.getBean("BookDAO");
		DigitalDAO digitalDao = (DigitalDAO) ctx.getBean("DigitalDAO");
		try
		{

			int type = Integer.parseInt(request.getParameter("type"));
			int entityId = Integer.parseInt(request.getParameter("entityId"));

//			System.out.println("type:" + type + "  entityID:" + entityId);
			if (type == 1)// Í¼Êé
			{
				InputStream is = null;
				OutputStream os = null;
				is = bookDao.findById(entityId).getPicture().getBinaryStream();
				response.setContentType("text/html");
				os = response.getOutputStream();
				int num;
				byte buf[] = new byte[1024];

				while ((num = is.read(buf)) != -1)
				{
					os.write(buf, 0, num);
				}
				is.close();
				os.close();
			} else if (type == 2)// ÊýÂë
			{
				InputStream is = null;
				OutputStream os = null;
				is = digitalDao.findById(entityId).getPhoto().getBinaryStream();
				response.setContentType("text/html");
				os = response.getOutputStream();
				int num;
				byte buf[] = new byte[1024];

				while ((num = is.read(buf)) != -1)
				{
					os.write(buf, 0, num);
				}
				is.close();
				os.close();
			} else
			{
				// response.sendRedirect("ok");
			}
		} catch (Exception e)
		{
			// e.printStackTrace();
		}
	}

}
