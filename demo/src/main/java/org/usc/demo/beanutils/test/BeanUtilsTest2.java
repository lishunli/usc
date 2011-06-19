package org.usc.demo.beanutils.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.usc.demo.beanutils.model.User;
import org.usc.demo.beanutils.utils.BeanUtils;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest2 {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, IllegalArgumentException, ParseException {
		User user = new User("lishunli", "lishunli", 23, new Date());

		Map<String, String> result = BeanUtils.convertBeanToMap(user);
		result.remove("class");

		User newUser = new User();
		for(Map.Entry<String, String> entry: result.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
//			org.apache.commons.beanutils.BeanUtils.setProperty(newUser, entry.getKey(), entry.getValue());
		}
//		BeanUtils.copyMapToBean(result,newUser);

		System.out.println(newUser);


//		BeanUtils.convertMapToBean(result, User.class);

//		System.out.println(newUser.getAge());
//		System.out.println(newUser);

//		Object convert = ConvertUtils.convert(result, User.class);
//
//		System.out.println(convert);


	}
}
