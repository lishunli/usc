package org.usc.demo.guava;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shunli on 2014/7/13.
 */
public class RateLimiterTest1 {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(0.5);


        Stopwatch sw = Stopwatch.createStarted();
        for (int i = 0; i < 10000000; i++) {
            boolean tryAcquire = rateLimiter.tryAcquire();
            if(tryAcquire){
                System.out.println(i);
                System.out.println(sw);
            }


            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
