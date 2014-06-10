package org.usc.demo.guava.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Shunli
 */
public class MapLockerTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int threadSize = 100;
            ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
            for (int j = 0; j < threadSize; j++) {
                executorService.execute(new LockThread("123555666"/* RandomStringUtils.randomAlphabetic(10) */));
            }

            executorService.shutdown();
        }
    }

    static class LockThread extends Thread {
        private String key;

        public LockThread(String key) {
            this.key = key;
        }

        @Override
        public void run() {
            if (!MapLocker.lock(key)) {
                System.out.println(Thread.currentThread().getName() + " not get locker at " + key);
                return;
            }

            try {
                System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + " lock at " + key);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
//                System.out.println(Thread.currentThread().getName() + " un locker at " + key);
//                MapLocker.unlock(key);
            }
        }
    }
}
