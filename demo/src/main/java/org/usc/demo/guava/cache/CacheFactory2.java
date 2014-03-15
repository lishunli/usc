package org.usc.demo.guava.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用Holder方式来实现单例工厂类，减少同步的需要
 *
 * @author Shunli
 */
@SuppressWarnings("rawtypes")
public class CacheFactory2 {
    private static final Map<Class<? extends AbstractCache1>, AbstractCache1> INSTANCES = new HashMap<Class<? extends AbstractCache1>, AbstractCache1>();

    private static class SingletonHolder<T> {
        private static <T> T getInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
            return clazz.newInstance();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends AbstractCache1> T getInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        if (INSTANCES.containsKey(clazz)) {
            return (T) INSTANCES.get(clazz);
        } else {
            T instance = SingletonHolder.getInstance(clazz);
            INSTANCES.put(clazz, instance);
            return instance;
        }
    }

    public static <T extends AbstractCache1> void putInstance(Class<T> clazz, T instance) {
        if (!INSTANCES.containsKey(clazz)) {
            INSTANCES.put(clazz, instance);
        }
    }
}
