package com.usc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.usc.dao.Pct;

public class GetAllCountrys extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ServletContext servletContext = request.getSession()
				.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		IPCTService ps = (IPCTService) ctx.getBean("PCTService");

		try
		{

			request.setCharacterEncoding("utf-8");
			String idStr = request.getParameter("parent_id");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			

			// out.println("<verifycodemes>" + "verifycode is error" +
			// "</verifycodemes>");

			// 1.È¡²ÎÊý
			String pid = request.getParameter("pid");
			String cid = request.getParameter("cid");
//			System.out.println(pid +"pid&cid" +cid);
			if("".equals(pid))
				pid = "0";
			else
				pid = URLDecoder.decode(pid, "UTF-8");
			if("".equals(cid))
			{
				cid = "0";
//				System.out.println("cid...");
			}
			else
				cid = URLDecoder.decode(cid, "UTF-8");
			
//			System.out.println("pid: " + pid +"cid:" +cid);
			StringBuffer allCitys = new StringBuffer();
			response.setContentType("text/xml");
			allCitys.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			allCitys.append("<allCitys>");
			
			
			
			
			
			if(ps.getCountrys(pid+cid).isEmpty())
			{
				System.out.println("empty");
				
			}
			else
			{
				
//				System.out.println("not empty");
				for(Pct pct : ps.getCountrys(pid+cid))
				{
//					System.out.println(pct.getPctid()+pct.getPctname());
					
					allCitys.append("<city>");
					allCitys.append("<cityId>" + pct.getPctid() + "</cityId>");
					allCitys.append("<cityName>" + pct.getPctname()+ "</cityName>");
					allCitys.append("</city>");
				}
			}

			
			allCitys.append("</allCitys>");
			out.print(allCitys.toString());
			
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
