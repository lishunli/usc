package org.usc.demo.guava;

import java.util.concurrent.locks.Lock;

import org.apache.commons.lang3.StringUtils;

import com.google.common.util.concurrent.Striped;

/**
 *
 * @author Shunli
 */
public class StripedLock {
    private static final Striped<Lock> STRIPPED_LOCK = Striped.lock(256);
    private static final String SYNC_LOCK_KEY_PREFIX = "ACT_SYNC_LOCK_";

    /**
     * @param key
     *            唯一性标识
     * @param field
     *            字段，建议使用String或者某些字段拼成的String
     * @return
     *         对某个字段加锁成功，返回 <code> true </code>, 否则返回 <code> false </code>
     */
    public static boolean lock(String key, Object field) {
        String keyWord = buildKeyWord(key, field);

        Lock lock = STRIPPED_LOCK.get(keyWord);
        return lock.tryLock();
        // try {
        // return lock.tryLock(10, TimeUnit.SECONDS);
        // } catch (InterruptedException e) {
        // return false;
        // }
    }

    /**
     * 解锁
     *
     * @param key
     *            唯一性标识，需要和加锁时候一致
     * @param field
     *            字段，建议使用String或者某些字段拼成的String
     */
    public static void unlock(String key, Object field) {
        Lock lock = STRIPPED_LOCK.get(buildKeyWord(key, field));
        lock.unlock();
    }

    private static String buildKeyWord(String key, Object field) {
        String keyWord = SYNC_LOCK_KEY_PREFIX;

        if (StringUtils.isNotEmpty(key)) {
            keyWord = keyWord + key + "_";
        }

        if (field != null && StringUtils.isNotEmpty(field.toString())) {
            keyWord += field.toString();
        }
        return keyWord;
    }
}
