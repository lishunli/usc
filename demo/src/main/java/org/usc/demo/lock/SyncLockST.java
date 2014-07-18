package org.usc.demo.lock;

/**
 *
 * @author Shunli
 */
public class SyncLockST {

    public static void main(String[] args) {
        System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID1"));
        System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID1"));
        System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID2"));
        System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID2"));

        SyncLockWithAtomicBoolean.unlock("TEST", "ID");

        System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID"));
        System.out.println(SyncLockWithAtomicBoolean.lock("TEST", "ID"));
    }

}
