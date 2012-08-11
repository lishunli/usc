package org.usc.demo.allocation;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class TestOderThread {

    private static Semaphore semaphore1 = new Semaphore(0);
    private static Semaphore semaphore2 = new Semaphore(0);
    public Thread t1;
    public Thread t2;
    public Thread t3;
    private static CountDownLatch latch;

    public TestOderThread() {
        t1 = new Thread() {
            public void run() {
                try {
                    System.out.print("A");
                    semaphore1.release();
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t2 = new Thread() {
            public void run() {
                try {
                    semaphore1.acquire();
                    System.out.print("B");
                    semaphore2.release();
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t3 = new Thread() {
            public void run() {
                try {
                    semaphore2.acquire();
                    System.out.print("C");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }

    public void run() {
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String args[]) throws Exception {
        TestOderThread t = new TestOderThread();
        for (int i = 0; i < 10; i++) {
            t = new TestOderThread();
            latch = new CountDownLatch(3);
            t.run();
            latch.await();
        }
    }
}
