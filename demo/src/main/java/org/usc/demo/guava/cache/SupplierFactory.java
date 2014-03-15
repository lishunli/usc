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
public class SupplierFactory {
    private static final LoadingCache<Class<? extends AbstractSupplier>, AbstractSupplier> cache =
            CacheBuilder.newBuilder().build(new CacheLoader<Class<? extends AbstractSupplier>, AbstractSupplier>() {
                @Override
                public AbstractSupplier load(Class<? extends AbstractSupplier> key) throws Exception {
                    return key.newInstance();
                }
            });

    @SuppressWarnings("unchecked")
    public static <T extends AbstractSupplier> T getInstance(Class<T> clazz) {
        try {
            return (T) cache.get(clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
