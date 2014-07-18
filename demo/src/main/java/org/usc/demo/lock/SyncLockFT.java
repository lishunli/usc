package org.usc.demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Shunli
 */
// @SuppressWarnings("unused")
public class SyncLockFT {
    private static final String key = "TEST";
    private static final String field = "ID";
    private static final int threads = 300;
    private static final AtomicBoolean runingSwitch = new AtomicBoolean(true);

    public static void main(String[] args) throws Exception {
        testSyncLock();
        testSyncLockWithGuavaCache();
        testSyncLockWithAtomicBoolean();

        TimeUnit.MINUTES.sleep(1);
        runingSwitch.set(false);
    }

    private static void testSyncLock() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final AtomicInteger counter = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLock.lock(key, field)) {
                                System.out.println(counter.incrementAndGet() + ". SyncLock lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        startSignal.countDown();

        new Thread(new Runnable() {
            public void run() {
                while (runingSwitch.get()) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        SyncLock.unlock(key, field);
                        System.out.println(counter.get() + ". SyncLock unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // executorService.shutdown();
    }

    private static void testSyncLockWithGuavaCache() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final AtomicInteger counter = new AtomicInteger();
        final AtomicBoolean runingSwitch = new AtomicBoolean(true);

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLockWithGuavaCache.lock(key, field)) {
                                System.out.println(counter.incrementAndGet() + ". SyncLockWithGuavaCache lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        startSignal.countDown();

        new Thread(new Runnable() {
            public void run() {
                while (runingSwitch.get()) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        SyncLockWithGuavaCache.unlock(key, field);
                        System.out.println(counter.get() + ". SyncLockWithGuavaCache unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // TimeUnit.MINUTES.sleep(1);
        // runingSwitch.set(false);
        // executorService.shutdown();
    }

    private static void testSyncLockWithAtomicBoolean() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final AtomicInteger counter = new AtomicInteger();
        final AtomicBoolean runingSwitch = new AtomicBoolean(true);

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLockWithAtomicBoolean.lock(key, field)) {
                                System.out.println(counter.incrementAndGet() + ". SyncLockWithAtomicBoolean lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        startSignal.countDown();

        new Thread(new Runnable() {
            public void run() {
                while (runingSwitch.get()) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        SyncLockWithAtomicBoolean.unlock(key, field);
                        System.out.println(counter.get() + ". SyncLockWithAtomicBoolean unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // TimeUnit.MINUTES.sleep(1);
        // runingSwitch.set(false);
        // executorService.shutdown();
    }

}
