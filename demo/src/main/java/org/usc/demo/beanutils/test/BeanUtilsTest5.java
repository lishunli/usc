package org.usc.demo.beanutils.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.usc.demo.beanutils.model.User;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest5 {
    private static User user, newUser;
    private static int count = 1000000;

    public static void main(String[] args) throws Exception {
        init();
        test1();
        test3();
        // test4();

    }

    public static void init() {
        user = new User("lishunli", "lishunli", 23, new Date());

        // params = new ArrayList<String>();
        // params.add("1");
        // params.add("2");
        //
        // user.setParams(params);

        newUser = new User();
    }

    public static void test1() throws IllegalAccessException, InvocationTargetException {
        long begin = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            BeanUtils.copyProperties(newUser, user);
        }

        System.out.println("BeanUtils.copyProperties:" + (System.currentTimeMillis() - begin));
    }

    public static void test3() {
        long begin = System.currentTimeMillis();

        DozerBeanMapper beanUtils = new DozerBeanMapper();
        for (int i = 0; i < count; i++) {
            beanUtils.map(user, newUser);
        }

        System.out.println("DozerBeanMapper.map:" + (System.currentTimeMillis() - begin));
    }

    public static void test4() {
        // Singleton Wrapper Method 1
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        long begin = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            newUser = mapper.map(user, User.class);
        }

        System.out.println("DozerBeanMapperSingletonWrapper.map:" + (System.currentTimeMillis() - begin));

    }

}
