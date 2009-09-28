package cn.itcast.strutsdemo.user.web.struts.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {

	public Object convert(Class clazz, Object obj) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if(clazz == Date.class)
		{
			String src = (String)obj;
			Date dest = null;
			try {
				dest = sdf.parse(src);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return dest;
		}
		else if(clazz == String.class)
		{
			Date src = (Date)obj;
			String dest = null;
			try {
				dest = sdf.format(src);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return dest;			
		}
		else
			return null;
	}

}
