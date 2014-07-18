package org.usc.demo.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class StripedExampleDriver {

    private ExecutorService executorService = Executors.newCachedThreadPool();
    private int numberThreads = 300;
    private CountDownLatch startSignal = new CountDownLatch(1);
    private CountDownLatch endSignal = new CountDownLatch(numberThreads);
    private Stopwatch stopwatch = Stopwatch.createUnstarted();
    private ConcurrentWorker worker = new ConcurrentWorker();
    private static final boolean USE_STRIPES = true;
    private static final boolean NO_STRIPES = false;
    private static final int POSSIBLE_TASKS_PER_THREAD = 10;

    public static void main(String[] args) throws Exception {
        StripedExampleDriver driver = new StripedExampleDriver();
        // driver.createData();
        driver.runStripedExample();
        driver.reset();
        driver.runNonStripedExample();
        // driver.shutdown();
    }

    private void reset() {
        startSignal = new CountDownLatch(1);
        endSignal = new CountDownLatch(numberThreads);
        stopwatch = Stopwatch.createUnstarted();
    }

    private void runStripedExample() throws InterruptedException {
        runExample(worker, USE_STRIPES, "Striped work");
    }

    private void runNonStripedExample() throws InterruptedException {
        runExample(worker, NO_STRIPES, "Non-Striped work");
    }

    private void runExample(final ConcurrentWorker worker, final boolean isStriped, String type) throws InterruptedException {
        for (int i = 0; i < numberThreads; i++) {
            final String value = (i % POSSIBLE_TASKS_PER_THREAD) + "";
            executorService.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    startSignal.await();
                    if (isStriped) {
                        worker.stripedConcurrentWork(value);
                    } else {
                        worker.nonStripedConcurrentWork(value);
                    }
                    endSignal.countDown();
                    return null;
                }
            });
        }

        stopwatch.start();
        startSignal.countDown();
        endSignal.await();
        stopwatch.stop();

        System.out.println("Time for" + type + " work [" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "] millis");
    }
}
