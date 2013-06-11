package org.usc.demo.clazz;

import com.google.common.base.Objects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class Parent1 {
    private static LoadingCache<Inner, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<Inner, String>() {
        @Override
        public String load(Inner inner) throws Exception {
            inner.getSuperClass().getDeclaredMethods();
            // System.out.println("Parent1->" + Arrays.toString(inner.getSuperClass().getDeclaredMethods()));
            return "1";
        }
    });

    public void doAction() throws Exception {
        cache.get(new Inner("/youxi-rh/rhtest", "test"));
    }

    private class Inner {
        private String uri;
        private String actionName;

        public Inner(String uri, String actionName) {
            this.uri = uri;
            this.actionName = actionName;
        }

        public Class<?> getSuperClass() {
            return Parent1.this.getClass();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Inner other = (Inner) obj;
            return Objects.equal(this.uri, other.uri) && Objects.equal(this.actionName, other.actionName);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(uri, actionName);
        }

    }

}
