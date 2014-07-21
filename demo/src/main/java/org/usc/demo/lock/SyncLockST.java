package org.usc.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Shunli
 */
public class SyncLockST {

    public static void main(String[] args) {
        // System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID1"));
        // System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID1"));
        // System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID2"));
        // System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID2"));
        //
        // SyncLockWithAtomicBoolean.unlock("TEST", "ID");
        //
        // System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID"));
        // System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID"));

        Lock lock = new ReentrantLock();
        while (true) {
            lock.lock();
            System.out.println(lock.tryLock());
        }
    }

}
