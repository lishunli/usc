package org.usc.demo.lock;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class SyncLockPT {
    private static final String key = "TEST";

    public static void main(String[] args) {
        // for (int i = 0; i < 100; i++) {
        // Stopwatch sw1 = Stopwatch.createStarted();
        // for (int j = 0; j < 100000; j++) {
        // SyncLock.lock(key, RandomStringUtils.randomAlphabetic(10));
        // }
        // SyncLock.unlockAll();
        // System.out.println(i + ". SyncLock lock escaped times: " + sw1.elapsed(TimeUnit.MILLISECONDS));
        // }

        for (int i = 0; i < 100; i++) {
            Stopwatch sw1 = Stopwatch.createStarted();
            for (int j = 0; j < 100000; j++) {
                SyncLockWithGuavaCache.lock(key, RandomStringUtils.randomAlphabetic(10));
            }
            SyncLockWithGuavaCache.unlockAll();
            System.out.println(i + ". SyncLockWithGuavaCache lock escaped times: " + sw1.elapsed(TimeUnit.MILLISECONDS));
        }
    }
}
