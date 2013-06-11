package org.usc.demo.clazz;

import java.util.Arrays;

import com.google.common.base.Objects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class Parent2 {
    private static LoadingCache<CacheKey, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<CacheKey, String>() {
        @Override
        public String load(CacheKey inner) throws Exception {
            System.out.println("Parent2->" + Arrays.toString(inner.getClazz().getDeclaredMethods()));
            return "1";
        }
    });

    public void doAction() throws Exception {
        cache.get(new CacheKey(getClass(), "test"));
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
