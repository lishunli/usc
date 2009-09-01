package com.usc.servlets;

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

import com.usc.daos.Producttype;
import com.usc.daos.ProducttypeDAO;

public class getAllType extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ServletContext servletContext = request.getSession()
				.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		ProducttypeDAO pTypeDao = (ProducttypeDAO) ctx
				.getBean("ProducttypeDAO");
		//获得ProducttypeDAO对象

		try
		{

			request.setCharacterEncoding("utf-8");
			String idStr = request.getParameter("parent_id");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			// 1.取参数
			String SFTypeID = request.getParameter("FTypeID");//从客户端获取数据
			if("".equals(SFTypeID))
				SFTypeID = "0";//父类
			else
				SFTypeID = URLDecoder.decode(SFTypeID, "UTF-8");
			int FTypeID = 0;
			try
			{
				FTypeID = Integer.parseInt(SFTypeID);//把传过来的数据转换为整数
			} catch (Exception e)
			{
			}
			StringBuffer allTypes = new StringBuffer();
			//下面都是用AJAX实现XML传递数据
			response.setContentType("text/xml");
			allTypes.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			allTypes.append("<allTypes>");

			if(!pTypeDao.findByFartherTypeId(FTypeID).isEmpty())//父类下面存在子类，就显示子类信息
			{
				for(Producttype pT : pTypeDao.findByFartherTypeId(FTypeID))
				{
					allTypes.append("<Type>");
					allTypes.append("<TypeID>" + pT.getProductTypeId() + "</TypeID>");//子类ID，这个ID又可能成为下一个父类ID
					allTypes.append("<TypeName>" + pT.getProductTypeName() + "</TypeName>");//子类名字
					allTypes.append("<TypeFID>" + pT.getFartherTypeId() + "</TypeFID>");
					allTypes.append("</Type>");
				}
			}
			allTypes.append("</allTypes>");
			out.print(allTypes.toString());//返回
			
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
