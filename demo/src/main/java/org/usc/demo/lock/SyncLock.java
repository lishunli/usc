package org.usc.demo.lock;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shunli
 */
public class SyncLock {
    private static final Map<String, Long> lockMap = new HashMap<String, Long>();

    public synchronized static boolean lock(String key, Object field) {
        String keyWord = SyncLockUtil.buildKeyWord(key, field);

        Long expiryTime = lockMap.get(keyWord);
        long currentTimeMillis = System.currentTimeMillis();
        if (expiryTime != null && currentTimeMillis < expiryTime) {
            return false;
        } else {
            lockMap.put(keyWord, currentTimeMillis + 1200 * 1000L); // 10s
            return true;
        }
    }

    public synchronized static void unlock(String key, Object field) {
        lockMap.remove(SyncLockUtil.buildKeyWord(key, field));
    }

    public synchronized static void unlockAll() {
        lockMap.clear();
    }

}
