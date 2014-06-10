package org.usc.demo.guava.lock;

import java.util.concurrent.ConcurrentMap;

import org.joda.time.DateTime;

import com.google.common.collect.Maps;

/**
 * ConcurrentMap方式实现同步锁，可以实现一定时间后自动获取锁（就算没结算）
 *
 * @author Shunli
 */
public class MapLocker {
    private static final ConcurrentMap<String, Long> mapLocker = Maps.newConcurrentMap();

    public static boolean lock(String key) {
        DateTime now = DateTime.now();
        long expiredTime = now.plusSeconds(120).getMillis();

        Long putIfAbsent = mapLocker.putIfAbsent(key, expiredTime);
        if (putIfAbsent == null) {
            return true;
        }

        if (now.getMillis() < putIfAbsent) {
            return false;
        }

        return mapLocker.replace(key, putIfAbsent, expiredTime);
    }

    public static void unlock(String key) {
        mapLocker.remove(key);
    }
}
