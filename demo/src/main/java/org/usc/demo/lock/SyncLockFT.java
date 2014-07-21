package org.usc.demo.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 检查对于对一个key进行加锁（解锁后加锁），同时只会有一个成功
 *
 * @author Shunli
 */
@SuppressWarnings("unused")
public class SyncLockFT {
    private static final String key = "TEST";
    private static final String field = "ID";
    private static final int threads = 100;
    private static final AtomicBoolean runingSwitch = new AtomicBoolean(true);

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                try {
                    testSyncLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    testSyncLockWithGuavaCache();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    testSyncLockWithAtomicBoolean();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // new Thread(new Runnable() {
        // public void run() {
        // try {
        // testSyncLockWithReentrantLock();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
        // }).start();

        TimeUnit.SECONDS.sleep(60);
        runingSwitch.set(false);
    }

    private static void testSyncLock() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch endSignal = new CountDownLatch(threads + 1);
        final AtomicInteger lockCounter = new AtomicInteger();
        final AtomicInteger unlockCounter = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLock.lock(key, field)) {
                                System.out.println(lockCounter.incrementAndGet() + ". SyncLock lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                        endSignal.countDown();
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
                        System.out.println(unlockCounter.incrementAndGet() + ". SyncLock unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                endSignal.countDown();
            }
        }).start();

        endSignal.await();
        System.out.println("SyncLock ==> lock=" + lockCounter.get() + ", unlock=" + unlockCounter.get());
        executorService.shutdown();
    }

    private static void testSyncLockWithGuavaCache() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch endSignal = new CountDownLatch(threads + 1);
        final AtomicInteger lockCounter = new AtomicInteger();
        final AtomicInteger unlockCounter = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLockWithGuavaCache.lock(key, field)) {
                                System.out.println(lockCounter.incrementAndGet() + ". SyncLockWithGuavaCache lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                        endSignal.countDown();
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
                        System.out.println(unlockCounter.incrementAndGet() + ". SyncLockWithGuavaCache unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                endSignal.countDown();
            }
        }).start();

        endSignal.await();
        System.out.println("SyncLockWithGuavaCache ==> lock=" + lockCounter.get() + ", unlock=" + unlockCounter.get());
        executorService.shutdown();
    }

    private static void testSyncLockWithAtomicBoolean() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch endSignal = new CountDownLatch(threads + 1);
        final AtomicInteger lockCounter = new AtomicInteger();
        final AtomicInteger unlockCounter = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLockWithAtomicBoolean.lock(key, field)) {
                                System.out.println(lockCounter.incrementAndGet() + ". SyncLockWithAtomicBoolean lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                        endSignal.countDown();
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
                        System.out.println(unlockCounter.incrementAndGet() + ". SyncLockWithAtomicBoolean unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                endSignal.countDown();
            }
        }).start();

        endSignal.await();
        System.out.println("SyncLockWithAtomicBoolean ==> lock=" + lockCounter.get() + ", unlock=" + unlockCounter.get());
        executorService.shutdown();
    }

    private static void testSyncLockWithReentrantLock() throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch endSignal = new CountDownLatch(threads + 1);
        final AtomicInteger lockCounter = new AtomicInteger();
        final AtomicInteger unlockCounter = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        while (runingSwitch.get()) {
                            if (SyncLockWithReentrantLock.lock(key, field)) {
                                System.out.println(lockCounter.incrementAndGet() + ". SyncLockWithReentrantLock lock by " + Thread.currentThread().getName() + " at " + System.currentTimeMillis());
                            }
                        }

                        endSignal.countDown();
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
                        SyncLockWithReentrantLock.unlock(key, field);
                        System.out.println(unlockCounter.incrementAndGet() + ". SyncLockWithReentrantLock unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                endSignal.countDown();
            }
        }).start();

        endSignal.await();
        System.out.println("SyncLockWithReentrantLock ==> lock=" + lockCounter.get() + ", unlock=" + unlockCounter.get());
        executorService.shutdown();
    }

}
