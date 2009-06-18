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
	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String requesturi = httpServletRequest.getRequestURI();
		// 通过检查session中的变量，过虑请求,最好把username提取出来当常量
		HttpSession session = httpServletRequest.getSession();
		Object indexflag = session.getAttribute("index");
		Object loginflag = session.getAttribute("login");
		// System.out.println("2...."+session.getAttribute("login"));
		Object addflag = session.getAttribute("addflag");
		// System.out.println("++++"+indexflag);
		if (requesturi.endsWith("/index.jsp")
				|| requesturi.endsWith("/init.do")
				|| requesturi.endsWith(httpServletRequest.getContextPath()
						+ "/"))
		{
		} else if (indexflag == null)
		{
			httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath()
					+ "/index.jsp");
			return;
		} else if (loginflag == null
				&& !requesturi.endsWith("/listAllStudent.jsp")
				&& !requesturi.endsWith("/listAllStudent.do")
				&& !requesturi.endsWith("/login.jsp")
				&& !requesturi.endsWith("/login.do")
				&& !requesturi.endsWith("/searchbyno.jsp")
				&& !requesturi.endsWith("/searchbyno.do")
				&& !requesturi.endsWith("/serachbyname.jsp")
				&& !requesturi.endsWith("/serachbyname.do")
				&& !requesturi.endsWith("/excel.do")
				&& !requesturi.endsWith("/pdf.do")
				)
		{
			httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath()
					+ "/login.jsp");
			// String reqUrl = httpServletRequest.getHeader("referer");
			// System.out.println("qingqiu..."+requesturi);
			if (requesturi.endsWith("/deleteStudent.do")
					|| requesturi.endsWith("/updatePStudent.do"))
			{
				// System.out.println("......" + request.getContentType());
				// System.out.println("+++++" + request.getContentType()
				// + "/listAllStudent.jsp");
				session.setAttribute("requrl", httpServletRequest
						.getContextPath()
						+ "/listAllStudent.do");
				return;
			}
			session.setAttribute("requrl", requesturi);
			return;
		} else if (requesturi.endsWith("/listAllStudent.jsp"))
		{
			httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath()
					+ "/listAllStudent.do");
			return;
		} else if (requesturi.endsWith("/addStudent.jsp") && addflag == null)
		{
			session.setAttribute("addflag", "true");
			httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath()
					+ "/init.do");
			return;
		} else if (requesturi.endsWith("/addStudent.jsp") && addflag != null)
		{
			session.removeAttribute("addflag");
		}


		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{

	}
}
