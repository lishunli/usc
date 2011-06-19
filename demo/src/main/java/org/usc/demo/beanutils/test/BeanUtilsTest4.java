package org.usc.demo.beanutils.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.usc.demo.beanutils.model.User;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest4 {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, IllegalArgumentException,
			ParseException {
		@SuppressWarnings("unused")
		User user = new User("lishunli", "lishunli", 23, new Date());
		User user2 = new User(); // new User("lishunli", "lishunli", 23,
									// newDate());

		Map<String, Object> properties = new HashMap<String, Object>();
		// properties.put("isActive", "Y");
		properties.put("password", "lishunli");
		properties.put("age", "23");
		 properties.put("birthDay", "2010-08-01");

		// 2010-08-01 00:00:00
		DozerBeanMapper beanUtils = new DozerBeanMapper();
		List<BeanMappingBuilder> mappingBuilder = new ArrayList<BeanMappingBuilder>();
//		BeanMappingBuilder e = new BeanMappingBuilderImpl();
		BeanMappingBuilder e = new BeanMappingBuilder() {
			@Override
			protected void configure() {

			}
		};



		mappingBuilder.add(e);
		// List<? extends BeanMappingBuilder> mappingBuilder = new ArrayList();
		beanUtils.setMappings(mappingBuilder);// setMappings(mappingBuilder );
		// beanUtils.map(properties, user2);

		beanUtils.map(properties, user2);

		System.out.println(user2);

		/*
		 * beanUtils.map(user2, properties); System.out.println(user2);
		 * System.out.println(properties);
		 *
		 * Long l1 = 2L;
		 *
		 * System.out.println(BeanUtils.convertBeanToMap(user2));;
		 *
		 * Boolean checking = Boolean.FALSE ; System.out.println(checking);
		 *
		 *
		 *
		 * // System.out.println(checkin);
		 *
		 * beanUtils.map(properties, user2); System.out.println(user2); // //
		 * System.out.println(user.getBirthDay().getTime());
		 *
		 * // BeanUtils.populate(user, properties);
		 *
		 * // System.out.println(user );
		 *
		 * // Set entrySet = properties.entrySet(); // for(Set entry: entrySet){
		 * // System.out.println(entry.getKey() + " : " + entry.getValue()); //
		 * }
		 */
	}
}
