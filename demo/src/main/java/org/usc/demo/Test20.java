package org.usc.demo;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Shunli
 */
public class Test20 {
    private static AtomicBoolean lock = new AtomicBoolean(true);

    public static boolean tryLock() {
        return lock.compareAndSet(true, false);
    }

    public static void unlock() {
        lock.set(true);
    }

    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock lock = rwLock.readLock();
        //
        System.out.println(lock.tryLock());
        System.out.println(lock.tryLock());
        System.out.println(lock.tryLock());

        System.out.println(tryLock());
        System.out.println(tryLock());
        System.out.println(tryLock());
    }
}
