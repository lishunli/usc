package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String currentURI = req.getRequestURI();
		System.out.println("currentURI=" + currentURI);
		
		String path = currentURI.substring(currentURI.indexOf("/", 1));
		
		path = path.substring(0, path.indexOf("."));
		
		System.out.println("path=" + path);
		
		String forwardPath = "";
		if ("/user/addUser".equals(path)) {
			Action action = new UserAddAction();
			forwardPath = action.execute(req, res);
//			System.out.println("---addUser---");
//			//ȡ�ñ�����
//			//����ҵ���߼�
//			//ת��
		}else if ("/user/modifyUser".equals(path)) {
			System.out.println("---modifyUser---");
			//ȡ�ñ�����
			//����ҵ���߼�
			//ת��
		}else if ("/user/queryUser".equals(path)) {
			Action action = new QueryUserAction();
			forwardPath = action.execute(req, res);
//			System.out.println("---queryUser---");
//			//ȡ�ñ�����
//			String username = req.getParameter("username");
//			UserManager userManager = new UserManager();
//			List userList = userManager.findUserByName(username);
//			req.setAttribute("userlist", userList);
//			
//			//ת��c.jsp��ȡ��list�е�����
//			req.getRequestDispatcher("/a/b/c/c.jsp").forward(req, res);
		}
		
		/**
		 * <action-config>
		 * 		<action path="/user/addUser" class="com.bjsxt.servlet.UserAddAction" success="/add_success.jsp"/>
		 *      <action path="/user/queryUser" class="com.bjsxt.servlet.QueryUserAction" success="/a/b/c/c.jsp"/>
		 * </action-config> 
		 * 
		 *  Action action = (Action)����Actionʵ��
		 *  String forwardPath = action.execute(request, response);
		 *  
		 *  req.getRequestDispatcher(forwardPath).forward(req, res);
		 */
		
		req.getRequestDispatcher(forwardPath).forward(req, res);
	}
}
