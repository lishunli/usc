package org.usc.demo.lottery.limit;

import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset.Entry;

/**
 *
 * @author Shunli
 */
public class LotteryUtilMTTest {

    public static void main(String[] args) throws Exception {
        final String lotteryLimitGiftsFileName = "lottery-gifts.txt";
        final ConcurrentHashMultiset<LotteryLimitGift> resultSet = ConcurrentHashMultiset.create();
        final int nThreads = 100;
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch endSignal = new CountDownLatch(nThreads);
        ExecutorService exec = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < nThreads; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int count = 1000;
                    for (int j = 0; j < count; j++) {
                        LotteryLimitGift lottery = LotteryUtil.lottery(lotteryLimitGiftsFileName);
                        if (lottery == null) {
                            continue;
                        }
                        resultSet.add(lottery);
                    }
                    endSignal.countDown();
                }
            });
        }

        startSignal.countDown();

        endSignal.await();
        exec.shutdown();

        Set<Entry<LotteryLimitGift>> entrySet = resultSet.entrySet();
        for (Entry<LotteryLimitGift> entry : entrySet) {
            System.out.println(entry);
        }
    }

}
