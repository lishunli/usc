package org.usc.demo.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.util.concurrent.Striped;

/**
 *
 * @author Shunli
 */
public class StripedDemo2 {
    private final static Striped<Lock> STRIPPED_LOCK = Striped.lock(64);

    public static void main(String[] args) {
        int threadSize = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(new LockThread(RandomStringUtils.randomNumeric(3)));
            // executorService.execute(new LockThread(RandomStringUtils.randomAlphabetic(10)));
        }

        executorService.shutdown();
    }

    static class LockThread extends Thread {
        private String id;

        public LockThread(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            Lock lock = STRIPPED_LOCK.get(id);
            // try {
            // if (!lock.tryLock(10, TimeUnit.SECONDS)) {
            // System.out.println(Thread.currentThread().getName() + " not get locker at " + id);
            // return;
            // }
            // } catch (InterruptedException e1) {
            // System.out.println(Thread.currentThread().getName() + " not get locker at " + id);
            // return;
            // }

            if (!lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " not get locker at " + id);
                return;
            }

            try {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " get locker at " + id);
            } finally {
                lock.unlock();
            }
        }
    }

}
