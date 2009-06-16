package com.bjsxt.struts;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class UtilDateConverterInitWithPlugin implements PlugIn {

	public void destroy() {
	}

	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		System.out.println("UtilDateConverterInitWithPlugin.init()");
		ConvertUtils.register(new UtilDateConverter(), Date.class);
	}
}
