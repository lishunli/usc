package org.usc.demo.guava;

import java.util.concurrent.Semaphore;

import com.google.common.util.concurrent.Striped;

public class ConcurrentWorker {

    private Striped<Semaphore> stripedSemaphores = Striped.lazyWeakSemaphore(10, 3);
    private Semaphore semaphore = new Semaphore(3);

    public void stripedConcurrentWork(String url) throws Exception {
        Semaphore stripedSemaphore = stripedSemaphores.get(url);
        stripedSemaphore.acquire();
        try {
            // Access restricted resource here
            Thread.sleep(25);
        } finally {
            stripedSemaphore.release();
        }
    }

    public void nonStripedConcurrentWork(String url) throws Exception {
        semaphore.acquire();
        try {
            // Access restricted resource here
            Thread.sleep(25);
        } finally {
            semaphore.release();
        }
    }
}
