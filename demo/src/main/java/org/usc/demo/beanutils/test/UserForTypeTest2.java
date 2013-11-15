package org.usc.demo.beanutils.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.usc.demo.beanutils.model.UserForType;

public class UserForTypeTest2 {
    public static void main(String[] args) {
        UserForType ut = new UserForType();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("setss", "s");
        params.put("setttt", new String[] { "key1", "value1", "key2", "value2" });
        params.put("setxxoo", new String[] { "key1", "value1", "key2", "value2" });

        String[] x = new String[] {};
        System.out.println(x.length);

        Method[] methods = ut.getClass().getMethods();
        ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
        for (Method method : methods) {
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();

            Object value = params.get(methodName.toLowerCase());
            if (value != null && parameterTypes.length > 0) {
                try {
                    method.invoke(ut, convertUtilsBean.convert(value, parameterTypes[0]));
                } catch (Exception e) {
                }
            }
        }

        System.out.println(ToStringBuilder.reflectionToString(ut, ToStringStyle.MULTI_LINE_STYLE));
    }
}
