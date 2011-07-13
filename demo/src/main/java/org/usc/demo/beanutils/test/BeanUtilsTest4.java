package org.usc.demo.beanutils.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.usc.demo.beanutils.model.User;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest4 {
    private User user, newUser;
    private List<String> params;

    @Before
    public void init() {
        user = new User("lishunli", "lishunli", 23, new Date());

        params = new ArrayList<String>();
        params.add("1");
        params.add("2");

        user.setParams(params);

        newUser = new User();
    }

    @Test
    public void test1() throws IllegalAccessException, InvocationTargetException {

        // Method 1 beanutils.BeanUtils.copyProperties
        BeanUtils.copyProperties(newUser, user);

        System.out.println(StringUtils.center(" orig ", 40, "-"));
        // modify orig will change dest
        params.add("3");
        user.getParams().add("4");

        System.out.println(user);

        System.out.println(StringUtils.center(" dest ", 40, "-"));
        // modify dest will not change orig
        newUser.getParams().remove("1");
        System.out.println(newUser);
    }

    @Test
    public void test2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // Method 2 beanutils.PropertyUtils.copyProperties
        PropertyUtils.copyProperties(newUser, user);

        System.out.println(StringUtils.center(" orig ", 40, "-"));
        // modify orig will change dest
        params.add("3");
        user.getParams().add("4");

        System.out.println(user);

        System.out.println(StringUtils.center(" dest ", 40, "-"));
        // modify dest will not change orig
        newUser.getParams().remove("1");
        System.out.println(newUser);
    }

    @Test
    public void test3() {
        // Method 3 DozerBeanMapper.map
        DozerBeanMapper beanUtils = new DozerBeanMapper();
        beanUtils.map(user, newUser);

        System.out.println(StringUtils.center(" orig ", 40, "-"));
        // modify orig will not change dest
        params.add("3");

        System.out.println(user);

        System.out.println(StringUtils.center(" dest ", 40, "-"));
        // modify destwill not change orig
        newUser.getParams().remove("1");
        System.out.println(newUser);
    }

    @Test
    public void test4() {
        // Singleton Wrapper Method 1
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        newUser = mapper.map(newUser, User.class);

        System.out.println(newUser);
    }

    @Test
    public void test5() {
        // SingletonWrapper Method 2
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        newUser = new User();
        mapper.map(user, newUser);

        System.out.println(newUser);
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, IllegalArgumentException, ParseException {
//        User user2 = new User(); // new User("lishunli", "lishunli", 23, // newDate());
//
//        Map<String, Object> properties = new HashMap<String, Object>(); // properties.put("isActive", "Y"); properties.put("password", "lishunli"); properties.put("age", "23"); properties.put("birthDay", "2010-08-01");
//
//        // 2010-08-01 00:00:00 DozerBeanMapper beanUtils = new DozerBeanMapper(); List<BeanMappingBuilder> mappingBuilder = new ArrayList<BeanMappingBuilder>(); // BeanMappingBuilder e = new BeanMappingBuilderImpl(); BeanMappingBuilder e = new BeanMappingBuilder() {
//
//
//
//        mappingBuilder.add(e); // List<? extends BeanMappingBuilder> mappingBuilder = new ArrayList(); beanUtils.setMappings(mappingBuilder);// setMappings(mappingBuilder ); // beanUtils.map(properties, user2);
//
//        beanUtils.map(properties, user2);
//
//        System.out.println(user2);
//
//
//
//        beanUtils.map(user2, properties); System.out.println(user2); System.out.println(properties);
//
//        Long l1 = 2L;
//
//        System.out.println(BeanUtils.convertBeanToMap(user2));;
//
//        Boolean checking = Boolean.FALSE ; System.out.println(checking);
//
//
//
//        // System.out.println(checkin);
//
//        beanUtils.map(properties, user2); System.out.println(user2); // // System.out.println(user.getBirthDay().getTime());
//
//        // BeanUtils.populate(user, properties);
//
//        // System.out.println(user );
//
//        // Set entrySet = properties.entrySet(); // for(Set entry: entrySet){ // System.out.println(entry.getKey() + " : " + entry.getValue()); // }

    }
}
