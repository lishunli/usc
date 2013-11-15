package org.usc.demo.beanutils.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.usc.demo.beanutils.model.UserForType;

public class UserForTypeTest3 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = UserForType.class;

        UserForType ut = (UserForType) clazz.newInstance();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sss", "s");
        params.put("tttt", new String[] { "key1", "value1", "key2", "value2" });
        params.put("xxxoo", new String[] { "key1", "value1", "key2", "value2" });

        Field[] declaredFields = clazz.getDeclaredFields();
        ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();

        for (Field field : declaredFields) {
            if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            String fieldName = field.getName();
            Class<?> type = field.getType();
            Object value = params.get(fieldName.toLowerCase());

            if (value != null) {
                System.out.println(fieldName);
                try {
                    Method method = clazz.getMethod("set" + StringUtils.capitalize(fieldName), type);
                    method.setAccessible(true);

                    method.invoke(ut, convertUtilsBean.convert(value, type));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(ToStringBuilder.reflectionToString(ut, ToStringStyle.MULTI_LINE_STYLE));
    }
}
