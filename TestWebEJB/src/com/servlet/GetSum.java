package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.webejb.Sum;


public class GetSum extends HttpServlet
{


	private Sum EJBDao;
	
	public Sum getEJBDao()
	{
		return EJBDao;
	}

	public void setEJBDao(Sum dao)
	{
		EJBDao = dao;
	}

	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int n1=Integer.parseInt(request.getParameter("num1"));
		int n2=Integer.parseInt(request.getParameter("num2"));
		int sum=EJBDao.GetSum(n1, n2);
		request.getSession().setAttribute("sum", ""+sum);
		request.getSession().setAttribute("n1", ""+n1);
		request.getSession().setAttribute("n2", ""+n2);
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		try
		{
			InitialContext inc =new InitialContext();
			Sum dao=(Sum) inc.lookup("Sum/SumBean/remote");
			//SumBean前面的Sum是Ear的文件的文件名
			this.setEJBDao(dao);
		
		} catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
