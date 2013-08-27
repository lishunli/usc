package org.usc.demo.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Shunli
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        // String giftId = "0001";
        // System.out.println(NomralCache.getKey(giftId));
        // System.out.println(NomralCache.getKey(giftId));

        long start = System.currentTimeMillis();
        int threadSize = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            executor.execute(new TestThread());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(System.currentTimeMillis() - start);
    }

}

class TestThread extends Thread {
    public TestThread() {
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            // NoLockCache.getKey("0001");
            System.out.println(NoLockCache.getKey("0001"));
        }
    }
}
