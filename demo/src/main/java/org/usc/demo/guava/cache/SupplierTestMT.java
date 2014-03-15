package org.usc.demo.guava.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Shunli
 */
public class SupplierTestMT {
    private static final int THREAD_SIZE = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(THREAD_SIZE);

        for (int i = 0; i < THREAD_SIZE; i++) {
            exec.execute(new SupplierTestThread());
        }
        exec.shutdown();
    }
}

class SupplierTestThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working: " + SupplierFactory.getInstance(Supplier1.class).get());
    }
}
