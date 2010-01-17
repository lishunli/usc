package org.usc.guestbook;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GuestbookServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		// /**
		// * 原来的代码
		// */
		// resp.setContentType("text/plain");
		// resp.getWriter().println("Hello, world");

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		if (null != user)
		{
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello," + user.getNickname());
		} else
		{
			resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
		}
	}
}
