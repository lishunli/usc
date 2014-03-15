package org.usc.demo.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 使用线程安全的Guava cache来作为单例模式的工厂类
 *
 * @author Shunli
 */
@SuppressWarnings("rawtypes")
public class CacheFactory3 {
    private static final LoadingCache<Class<? extends AbstractCache1>, AbstractCache1> cache =
            CacheBuilder.newBuilder().build(new CacheLoader<Class<? extends AbstractCache1>, AbstractCache1>() {
                @Override
                public AbstractCache1 load(Class<? extends AbstractCache1> key) throws Exception {
                    return key.newInstance();
                }
            });

    @SuppressWarnings("unchecked")
    public static <T extends AbstractCache1> T getInstance(Class<T> clazz) {
        try {
            return (T) cache.get(clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
