package org.usc.demo.synchronization;

/**
 * 以.class对象作为锁对象的话，那么只要是访问这个类的都会被锁
 *
 * @author ShunLi
 */
public class SynchronizationTest4 {
    public static void sync(String threadName, String key) {
        String msg = threadName + ":";
        System.out.println(msg + "sync1 start...");

        synchronized (key) {
            System.out.println(System.currentTimeMillis() + ":" + msg + "sync1 hit it");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg + "sync1 end...");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    String name = Thread.currentThread().getName();
                    // System.out.println(name);
                    // String key = Thread.currentThread().getId() % 10 + "";
                    // String key = new String("1");
                    String key = "";
                    sync(name, key);
                }
            }).start();
        }

    }
}
