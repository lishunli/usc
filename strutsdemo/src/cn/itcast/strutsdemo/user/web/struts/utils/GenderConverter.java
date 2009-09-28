package cn.itcast.strutsdemo.user.web.struts.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

import cn.itcast.strutsdemo.user.domain.Gender;

public class GenderConverter implements Converter {

	public Object convert(Class clazz, Object obj) {
		// TODO Auto-generated method stub
		return Gender.valueOf((String)obj);
	}
}
