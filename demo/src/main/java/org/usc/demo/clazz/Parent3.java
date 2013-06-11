package org.usc.demo.clazz;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class Parent3 {
    private static LoadingCache<CacheKey, Method> cache = CacheBuilder.newBuilder().build(
            new CacheLoader<CacheKey, Method>() {
                @Override
                public Method load(CacheKey key) throws Exception {
                    Class<?> clazz = key.getClazz();
                    String actionName = key.getActionName();
                    System.out.println("load-cache:" + clazz + "," + actionName);

                    if (StringUtils.isNotEmpty(actionName)) {
                        Method[] declaredMethods = clazz.getDeclaredMethods();
                        for (Method method : declaredMethods) {
                            if (method.getParameterTypes().length == 0
                                    && actionName.equalsIgnoreCase(method.getName())) {
                                // method.setAccessible(true);
                                return method;
                            }
                        }
                    }

                    throw new NoSuchMethodException();
                }
            });

    public void doAction(String actionName) {
        try {
            Method method = cache.get(new CacheKey(getClass(), actionName));
            method.invoke(this);
        } catch (Exception e) {
        }

    }

    private class CacheKey {
        private Class<?> clazz;
        private String actionName;

        public CacheKey(Class<?> clazz, String actionName) {
            this.clazz = clazz;
            this.actionName = actionName;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public String getActionName() {
            return actionName;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            CacheKey other = (CacheKey) obj;
            return Objects.equal(this.clazz, other.clazz) && Objects.equal(this.actionName, other.actionName);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(clazz, actionName);
        }
    }

}
