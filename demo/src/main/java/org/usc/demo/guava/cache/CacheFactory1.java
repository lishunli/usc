package org.usc.demo.guava.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用普通的方式来实现单例工厂类，注意double check和java内存模型（volatile）
 *
 * @author Shunli
 */
@SuppressWarnings("rawtypes")
public class CacheFactory1 {
    private volatile static Map<Class<? extends AbstractCache1>, AbstractCache1> INSTANCES_MAP = new HashMap<Class<? extends AbstractCache1>, AbstractCache1>();

    private CacheFactory1() {
    }

    @SuppressWarnings("unchecked")
    public static <E extends AbstractCache1> E getInstance(Class<E> instanceClass) {
        if (INSTANCES_MAP.containsKey(instanceClass)) {
            return (E) INSTANCES_MAP.get(instanceClass);
        } else {
            synchronized (CacheFactory1.class) {
                if (!INSTANCES_MAP.containsKey(instanceClass)) {
                    try {
                        E instance = instanceClass.newInstance();
                        INSTANCES_MAP.put(instanceClass, instance);
                        return instance;
                    } catch (Exception e) {
                        return null;
                        // or throw RuntimeException()
                    }
                } else {
                    return (E) INSTANCES_MAP.get(instanceClass);
                }
            }
        }
    }
}
