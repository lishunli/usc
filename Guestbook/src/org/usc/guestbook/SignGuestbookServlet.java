package org.usc.guestbook;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import org.usc.guestbook.Greeting;
import org.usc.guestbook.PMF;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17上午11:42:34<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */

public class SignGuestbookServlet extends HttpServlet
{
	private static final Logger log = Logger.getLogger(SignGuestbookServlet.class.getName());

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		String content = req.getParameter("content");
		Date date = new Date();
		Greeting greeting = new Greeting(user, content, date);

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try
		{
			pm.makePersistent(greeting);
		} finally
		{
			pm.close();
		}

		resp.sendRedirect("/intl/zh-CN/guestbook.jsp");
	}
}