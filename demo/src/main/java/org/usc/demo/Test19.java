package org.usc.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Shunli
 */
public class Test19 {
    // private static int c = 0;

    public static void main(String[] args) {

        // Semaphore semp = new Semaphore(1);
        // while (true) {
        // System.out.println(semp.tryAcquire());
        //
        // semp.release();
        // }

        Lock lock = new ReentrantLock();
        System.out.println(lock.tryLock());
        System.out.println(lock.tryLock());
        System.out.println(lock.tryLock());
        // Thread t1 = new Thread() {
        // public void run() {
        // for (int i = 0; i < 10000; i++) {
        // if (!lock.tryLock()) {
        // c++;
        // }
        // lock.unlock();
        // }
        // }
        // };
        // t1.start();
        //
        // while (t1.isAlive()) {
        // System.out.println("xx"+c);
        // }

        String phone = "13712345678";
        System.out.println(showPhone(phone));
    }

    private static String showPhone(String phone) {
        boolean showFullPhone = false;
        if (showFullPhone) {
            return phone;
        }

        int start = 3;
        int end = 7;
        return StringUtils.overlay(phone, StringUtils.repeat("*", end - start), start, end);
    }
}
