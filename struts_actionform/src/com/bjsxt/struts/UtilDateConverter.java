package com.bjsxt.struts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * java.util.DateÀàÐÍ×ª»»Æ÷
 * @author Administrator
 *
 */
public class UtilDateConverter implements Converter {

	public Object convert(Class type, Object value) {
		System.out.println("UtilDateConverter.value=" + value);
		if (value == null) {
			return value;
		}
		if (value instanceof Date) {
			return value;
		}
		Date d = null;
		if (value instanceof String) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				d = sdf.parse((String)value);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return d;
	}

}
