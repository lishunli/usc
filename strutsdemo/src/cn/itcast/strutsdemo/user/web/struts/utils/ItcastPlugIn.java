package cn.itcast.strutsdemo.user.web.struts.utils;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

public class ItcastPlugIn implements PlugIn {

	private String converterClassName;
	private String typeName;

	public String getConverterClassName() {
		return converterClassName;
	}

	public void setConverterClassName(String converterClassName) {
		this.converterClassName = converterClassName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(ActionServlet servlet, ModuleConfig config)
			throws ServletException {
		// TODO Auto-generated method stub
		try {
			System.out.println(converterClassName + ":" + typeName);
			Object converter = Class.forName(converterClassName).newInstance();
			ConvertUtils.register((Converter)converter, Class.forName(typeName));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
