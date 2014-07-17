package org.usc.demo.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class StripedDemo3 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int threadSize = 100;
            ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
            for (int j = 0; j < threadSize; j++) {
                executorService.execute(new LockThread(RandomStringUtils.randomAlphabetic(10)));
                // executorService.execute(new LockThread(RandomStringUtils.randomAlphabetic(10)));
            }

            executorService.shutdown();
        }

    }

    static class LockThread extends Thread {
        private String id;

        public LockThread(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            if (!StripedLock.lock("test", id)) {
                System.out.println(Thread.currentThread().getName() + " not get locker at " + id);
                return;
            }

            try {
                System.out.println(Thread.currentThread().getName() + " get locker at " + id);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                // System.out.println(Thread.currentThread().getName() + " un locker at " + id);
                StripedLock.unlock("test", id);
            }
        }
    }

}
