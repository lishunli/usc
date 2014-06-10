package org.usc.demo.guava.lock;

import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.collect.Lists;

/**
 * CopyOnWriteArrayList 来实现同步锁，缺点不可控制过期时间（即如果忘记解锁的话一定时间后还是能获得锁）
 *
 * @author Shunli
 */
public class ListLocker {
    private static final CopyOnWriteArrayList<String> lockerList = Lists.newCopyOnWriteArrayList();

    public static boolean lock(String key) {
        return lockerList.addIfAbsent(key);
    }

    public static boolean unlock(String key) {
        return lockerList.remove(key);
    }
}
