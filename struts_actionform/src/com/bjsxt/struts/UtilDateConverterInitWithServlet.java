package com.bjsxt.struts;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * ×¢²ájava.util.date×ª»»Æ÷
 * @author Administrator
 *
 */
public class UtilDateConverterInitWithServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("UtilDateConverterInitWithServlet.init()");
		ConvertUtils.register(new UtilDateConverter(), Date.class);
	}

}
