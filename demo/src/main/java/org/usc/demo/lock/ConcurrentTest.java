package org.usc.demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public static int getCount() {
        lock.lock();
        try {
            return count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String args[]) throws Exception {
        for (int j = 0; j < 10; j++) {
            int threads = 100;
            final CountDownLatch startSignal = new CountDownLatch(1);
            final CountDownLatch endSignal = new CountDownLatch(threads);

            ExecutorService executorService = Executors.newFixedThreadPool(threads);
            for (int i = 0; i < threads; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            startSignal.await();
                        } catch (InterruptedException e) {
                        }

                        for (int i = 0; i < 10; i++) {
                            getCount();
                        }

                        endSignal.countDown();
                    }
                });
            }

            startSignal.countDown();
            endSignal.await();
            executorService.shutdown();
            System.out.println("hi:" + count);
        }
    }
}
