package org.usc.demo.synchronization;

import java.util.Arrays;
import java.util.List;

/**
 * 以实例对象为锁对象的话，只要对象不同，就不会有同步锁，如果对象相同，才会有同步锁
 *
 * @author ShunLi
 */
public class SynchronizationTest2 {
    public static void sync(String threadName, User user) {
        String msg = threadName + ":" + user + ":";
        System.out.println(msg + "sync1 start...");

        synchronized (user) {
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
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        final List<User> users = Arrays.asList(user1, user2, user3);

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    String name = Thread.currentThread().getName();
                    // System.out.println(name);
                    sync(name, users.get((int) Thread.currentThread().getId() % 3));
                }
            }).start();
        }
    }

    static class User {
        private String userName;
        private String passWord;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }
    }
}
