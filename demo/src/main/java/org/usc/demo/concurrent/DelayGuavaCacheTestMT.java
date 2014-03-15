package org.usc.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayGuavaCacheTestMT<K, V> {
    private static final int THREAD_SIZE = 50;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(THREAD_SIZE);

        for (int i = 0; i < THREAD_SIZE; i++) {
            exec.execute(new DelayGuavaCacheTestThread());
        }
        exec.shutdown();
    }
}

class DelayGuavaCacheTestThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " working: ");
        while (true) {
            DelayGuavaCache.get("1");
        }
    }
}
