/*
 * BeanUtils.java
 *
 * Created on Jan 21, 2010
 *
 * Copyright (c) 2010 Tai Fook Securities Group Limited.
 * All rights reserved.
 *
 * This file contains the valuable properties of Tai Fook Securities
 * Group Limited, embodying substantial creative efforts and confidential
 * information, ideas and expressions. No part of this file may be
 * reproduced or distributed in any form or by any means, or stored
 * in a data base or a retrieval system, without the prior written
 * permission of Tai Fook Securities Group Limited.
 */
package org.usc.demo.beanutils.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

//TODO this utils class should be used for report parameter. i.e. the class name should be changed.
/**
 * Utility methods which is used to converting java object from/to other java type.
 */
public class BeanUtils {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String[] DATE_FORMATS = { DATE_FORMAT };
	public static final String[] DATE_TIME_FORMATS = { DATE_TIME_FORMAT };

	/**
	 * Convert the properties of <code>bean</code> object to string map.
	 * 
	 * @param bean
	 *            java object which will be converted to map.
	 * @return the converted map.
	 */
	public static Map<String, String> convertBeanToMap(Object bean) {
		Map<String, String> map = new HashMap<String, String>();

		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(bean);

		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String propName = propertyDescriptor.getName();
			try {
				String propValue = null;
				Object prop = PropertyUtils.getProperty(bean, propName);
				if (prop == null) {
					propValue = null;
				} else if (prop instanceof Boolean) {
					propValue = (((Boolean) prop).booleanValue()) ? "Y" : "N";
				} else if (prop instanceof Timestamp) {
					propValue = DateFormatUtils.format((Timestamp) prop, DATE_TIME_FORMAT);
				} else if (prop instanceof Date) {
					propValue = DateFormatUtils.format((Date) prop, DATE_FORMAT);
				} else {
					propValue = prop.toString();
				}
				map.put(propName, propValue);
			} catch (Exception e) {
				throw new RuntimeException("Fail to convert the bean property: " + propName, e);
			}
		}

		return map;
	}

	public static void convertMapToBean(Map<String, String> map, @SuppressWarnings("rawtypes") Class clazz) {
		Object bean = ConvertUtils.convert(map, clazz);
		System.out.println(bean);
	}

	/**
	 * Copy the object in map into the bean object.
	 * 
	 * @param map
	 *            extract the value of map which will be copy to the bean.
	 * @param bean
	 *            bean which value will be replaced by map.
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 * 
	 */
	public static void copyMapToBean(@SuppressWarnings("rawtypes") Map map, Object bean) throws IllegalArgumentException, ParseException {

		Field[] fs = bean.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			try {
				String key = f.getName();
				Object value = map.get(key);

				if (value != null) {
					if (f.getType().equals(BigDecimal.class)) {
						f.set(bean, new BigDecimal((String) value));
					} else if (f.getType().equals(Boolean.class) || f.getType().equals(boolean.class)) {
						f.set(bean, Boolean.valueOf(((String) value).equalsIgnoreCase("Y")));
					} else if (f.getType().equals(Date.class)) {
						f.set(bean, DateUtils.parseDate((String) value, DATE_FORMATS));
					} else if (f.getType().equals(Timestamp.class)) {
						f.set(bean, DateUtils.parseDate((String) value, DATE_TIME_FORMATS));
					} else if (f.getType().equals(Long.class)) {
						f.set(bean, Long.valueOf((String) value));
					} else if (f.getType().equals(Integer.class)) {
						f.set(bean, Integer.valueOf((String) value));

					} else {
						try {
							String methodName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
							Method method = bean.getClass().getDeclaredMethod(methodName, String.class);
							method.invoke(bean, value.toString());
						} catch (NoSuchMethodException e) {

						} catch (InvocationTargetException e) {

						}
					}
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("copyMapToBean has problem...", e);
			}
		}
	}

	/**
	 * Convert the java object to string.
	 * 
	 * @param bean
	 *            java object which will convert to string.
	 * @return string represent the java object.
	 */
	public static String beanToString(Object bean) {
		Map<String, String> map = BeanUtils.convertBeanToMap(bean);
		int count = 0;
		StringBuffer beanString = new StringBuffer("{");
		for (String key : map.keySet()) {
			if (count > 0) {
				beanString.append(", ");
			}
			beanString.append(key).append("=").append(map.get(key));
			count++;
		}
		beanString.append("}");
		return beanString.toString();
	}

}
