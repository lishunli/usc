package org.usc.demo.clazz;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Shunli
 */
public class Test2 {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        int count = 100000000;

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.execute(new A(count, begin));
        exec.execute(new B(count, begin));
        exec.execute(new C(count, begin));
        exec.shutdown();

        begin.countDown();
    }
}

class A implements Runnable {
    int count;
    CountDownLatch begin;

    public A(int count, CountDownLatch begin) {
        this.count = count;
        this.begin = begin;
    }

    @Override
    public void run() {
        try {
            begin.await();

            long start = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                new Child3().doAction("do1");
            }
            System.out.println("Child3-" + (System.currentTimeMillis() - start));
        } catch (Throwable e) {
        }
    }
}

class B implements Runnable {
    int count;
    CountDownLatch begin;

    public B(int count, CountDownLatch begin) {
        this.count = count;
        this.begin = begin;
    }

    @Override
    public void run() {
        try {
            begin.await();

            long start = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                new Child4().doAction("do1");
            }
            System.out.println("Child4-" + (System.currentTimeMillis() - start));
        } catch (Throwable e) {
        }
    }
}

class C implements Runnable {
    int count;
    CountDownLatch begin;

    public C(int count, CountDownLatch begin) {
        this.count = count;
        this.begin = begin;
    }

    @Override
    public void run() {
        try {
            begin.await();

            long start = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                new Child5().doAction("do1");
            }
            System.out.println("Child5-" + (System.currentTimeMillis() - start));
        } catch (Throwable e) {
        }
    }
}
