package org.usc.demo.beanutils.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.usc.demo.beanutils.model.User;
import org.usc.demo.beanutils.utils.BeanUtils;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest3 {
    private static final String  DATE_FORMAT = "yyyy-MM-dd";
    private static final String  DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, IllegalArgumentException, ParseException {
        User user = new User("lishunli", "lishunli", 23, new Date());
        user.setLogin(true);
        // User user2 = new User();
        System.out.println(BeanUtils.convertBeanToMap(user));
        // BeanUtils.copyMapToBean(BeanUtils.convertBeanToMap(user), user2);
        // System.out.println(user2);

        @SuppressWarnings("rawtypes") Map map = BeanUtils.convertBeanToMap(user);
        Field[] fs = user.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            try {
                String key = f.getName();
                Object value = map.get(key);
                System.out.println(key + " : " + f.getType());

                if (value != null) {
                    if (f.getType().equals(BigDecimal.class)) {
                        f.set(user, new BigDecimal((String) value));
                    } else if (f.getType().equals(Boolean.class) || f.getType().equals("boolean")) {
                        System.out.println(f.getType().isPrimitive());
                        f.set(user, Boolean.valueOf(((String) value).equalsIgnoreCase("Y")));
                    } else if (f.getType().equals(Date.class)) {
                        f.set(user, DateUtils.parseDate((String) value, DATE_FORMAT));
                    } else if (f.getType().equals(Timestamp.class)) {
                        f.set(user, DateUtils.parseDate((String) value, DATE_TIME_FORMAT));
                    } else if (f.getType().equals(Long.class)) {
                        f.set(user, Long.valueOf((String) value));
                    } else if (f.getType().equals(Integer.class)) {
                        f.set(user, Integer.valueOf((String) value));

                    } else {
                        try {
                            String methodName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                            Method method = user.getClass().getDeclaredMethod(methodName, String.class);
                            method.invoke(user, value.toString());
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

}
