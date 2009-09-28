package cn.itcast.strutsdemo.user.web.struts.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigManagerListener implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		String configPath = sce.getServletContext().getRealPath("WEB-INF/itcast.properties");
		sce.getServletContext().setAttribute(Constants.CONFIGMANAGERKEY, new ConfigManager2(configPath));
		
	}

}
