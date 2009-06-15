package com.usc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 设置字符集、过滤未登录的非法请求
 */
public class UserLoginFilter implements Filter
{
	protected String encoding = null;

	protected FilterConfig filterConfig = null;

	protected boolean ignore = false;

	protected String forwardPath = null;

	public void destroy()
	{
		this.encoding = null;
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{

		// // 设置编码方式，web.xml里面有filter参数的初始化设置
		// if (ignore || (request.getCharacterEncoding() == null))
		// {
		// String encoding = selectEncoding(request);
		// if (encoding != null)
		// request.setCharacterEncoding(encoding);
		// }
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String requesturi = httpServletRequest.getRequestURI();
		// 通过检查session中的变量，过虑请求,最好把username提取出来当常量
		HttpSession session = httpServletRequest.getSession();
		Object indexflag = session.getAttribute("index");
		// 当前会话用户为空而且不是请求登录，退出登录，欢迎页面和根目录则退回到应用的根目录
		// if (
		// indexflag == null&&
		// !requesturi.endsWith("/login.action")
		// && !requesturi.endsWith("/logout.action")
		// && !requesturi.endsWith("/index.jsp")
		// && !requesturi.endsWith(httpServletRequest.getContextPath()
		// + "/"))
		// {
		// httpServletResponse.sendRedirect(httpServletRequest
		// .getContextPath()
		// + "/");
		// return;
		// }
//		System.out.println("++++"+indexflag);
		if(requesturi.endsWith("/index.jsp") || requesturi.endsWith(httpServletRequest.getContextPath()+"/"))
		{			
		}
		else if(indexflag == null)
		{
			httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath()
					+ "/index.jsp");
//			System.out.println("----"+indexflag);
			return;
		}
		
//		if (!requesturi.endsWith("/index.jsp") || indexflag == null  )
//		{	
//			httpServletResponse.sendRedirect(httpServletRequest
//					.getContextPath()
//					+ "/index.jsp");
//			System.out.println("----"+indexflag);
//			return;
//		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

	// public void init(FilterConfig filterConfig) throws ServletException
	// {
	// this.filterConfig = filterConfig;
	// this.encoding = filterConfig.getInitParameter("encoding");
	// this.forwardPath = filterConfig.getInitParameter("forwardpath");
	// String value = filterConfig.getInitParameter("ignore");
	// if (value == null)
	// this.ignore = true;
	// else if (value.equalsIgnoreCase("true"))
	// this.ignore = true;
	// else if (value.equalsIgnoreCase("yes"))
	// this.ignore = true;
	// else
	// this.ignore = false;
	// }
	//
	// protected String selectEncoding(ServletRequest request)
	// {
	// return (this.encoding);
	// }
}
