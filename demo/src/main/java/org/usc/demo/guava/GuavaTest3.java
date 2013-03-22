package org.usc.demo.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class GuavaTest3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LoadingCache<String, Rtn> cache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS).build(new CacheLoader<String, Rtn>() {
            @Override
            public Rtn load(String key) throws Exception {
                Thread.sleep(5000);

                System.out.println("load " + key);

                return new Rtn(key);
            }
        });

        for (int i = 0; i < 10; i++) {
            new TestThread(i, cache).start();
        }

        for (int i = 0; i < 10; i++) {
            new TestThread(i, cache).start();
        }
    }
}

class TestThread extends Thread {
    private int num;
    private LoadingCache<String, Rtn> cache;

    public TestThread(int num) {
        this.num = num;
    }

    public TestThread(int num, LoadingCache<String, Rtn> cache) {
        this.num = num;
        this.cache = cache;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "-" + cache.get(num + ""));

            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Rtn {
    private String value;

    public Rtn(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
