package org.usc.demo.lock;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 某个字段的同步锁
 *
 * 如果要在分布式系统中使用，请使用下面注释的代码（用MC替换Map）
 *
 * @author Shunli
 */
public class SyncLockWithGuavaCache {
    private static Cache<String, Object> lockCache = CacheBuilder.newBuilder().expireAfterWrite(1200, TimeUnit.SECONDS).build();

    public synchronized static boolean lock(String key, Object field) {
        String keyWord = SyncLockUtil.buildKeyWord(key, field);

        if (lockCache.getIfPresent(keyWord) == null) {
            lockCache.put(keyWord, keyWord);
            return true;
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
