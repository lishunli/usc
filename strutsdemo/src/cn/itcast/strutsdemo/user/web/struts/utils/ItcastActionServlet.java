package cn.itcast.strutsdemo.user.web.struts.utils;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionServlet;

import cn.itcast.strutsdemo.user.domain.Gender;

public class ItcastActionServlet extends ActionServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ConvertUtils.register(new DateConverter(), Date.class);	
		ConvertUtils.register(new GenderConverter(), Gender.class);	
	}
}
