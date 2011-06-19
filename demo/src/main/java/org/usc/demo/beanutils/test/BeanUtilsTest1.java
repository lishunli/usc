package org.usc.demo.beanutils.test;

import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.usc.demo.beanutils.model.User;
import org.usc.demo.beanutils.utils.BeanUtils;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest1 {
	public static void main(String[] args) {
		User user = new User("lishunli", "lishunli", 23, new Date());

		try {
			for (@SuppressWarnings("unused") PropertyDescriptor propertyDescriptor : PropertyUtils.getPropertyDescriptors(user)) {
//				System.out.println(PropertyUtils.getProperty(user, propertyDescriptor.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> result = BeanUtils.convertBeanToMap(user);

		for(Map.Entry<String, String> entry: result.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}
}
