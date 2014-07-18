package org.usc.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 某个字段的同步锁
 *
 * 如果要在分布式系统中使用，请使用下面注释的代码（用MC替换Map）
 *
 * @author Shunli
 */
public class SyncLockWithAtomicBoolean {
    private static LoadingCache<String, AtomicBoolean> lockCache =
            CacheBuilder.newBuilder().expireAfterWrite(1200, TimeUnit.SECONDS).build(
                    new CacheLoader<String, AtomicBoolean>() {
                        @Override
                        public AtomicBoolean load(String key) throws Exception {
                            return new AtomicBoolean(true);
                        }
                    });

    public static boolean lock(String key, Object field) {
        String keyWord = SyncLockUtil.buildKeyWord(key, field);

        try {
            return lockCache.get(keyWord).compareAndSet(true, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void unlock(String key, Object field) {
        lockCache.invalidate(SyncLockUtil.buildKeyWord(key, field));
    }

    public static void unlockAll() {
        lockCache.invalidateAll();
    }
}
