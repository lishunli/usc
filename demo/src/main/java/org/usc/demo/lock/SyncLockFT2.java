package org.usc.demo.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 检查多余不同的key（不重复）加锁，都会成功
 *
 * @author Shunli
 */
public class SyncLockFT2 {
    private static final String key = "TEST";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            int threadSize = 100;
            ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
            for (int j = 0; j < threadSize; j++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        String field = RandomStringUtils.randomAlphabetic(10);

                        if (!SyncLockWithGuavaCache.lock(key, field)) {
                            System.out.println("not get locker at " + field);
                            return;
                        }

//                        SyncLockWithGuavaCache.unlock(field, field);
                    }
                });
            }

            executorService.shutdown();
        }
    }

}
