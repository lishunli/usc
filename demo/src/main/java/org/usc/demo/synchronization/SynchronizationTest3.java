package org.usc.demo.synchronization;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 初步猜测java synchronized对对象的同步锁并不是根据对象的equals()来得
 *
 * @author ShunLi
 */
public class SynchronizationTest3 {

    // public static void sync(String threadName, Server server) {
    // String msg = threadName + ":" + server + ":";
    // System.out.println(msg + "sync1 start...");
    //
    // synchronized (server) {
    // System.out.println(System.currentTimeMillis() + ":" + msg + "sync1 hit it");
    // try {
    // Thread.sleep(5000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // System.out.println(msg + "sync1 end...");
    // }
    //
    // public static void sync(String threadName, String server) {
    // String msg = threadName + ":" + server + ":";
    // System.out.println(msg + "sync1 start...");
    //
    // synchronized (server) {
    // System.out.println(System.currentTimeMillis() + ":" + msg + "sync1 hit it");
    // try {
    // Thread.sleep(5000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // System.out.println(msg + "sync1 end...");
    // }
    //
    // public static void sync(String threadName, Long server) {
    // String msg = threadName + ":" + server + ":";
    // System.out.println(msg + "sync1 start...");
    //
    // synchronized (server) {
    // System.out.println(System.currentTimeMillis() + ":" + msg + "sync1 hit it");
    // try {
    // Thread.sleep(5000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // System.out.println(msg + "sync1 end...");
    // }

    public static void sync(String threadName, Object server) {
        String msg = threadName + ":" + server + ":";
        System.out.println(msg + "sync1 start...");

        synchronized (server) {
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
        RandomStringUtils.random(10);
        // User user1 = new User();
        // User user2 = new User();
        // User user3 = new User();
        // final List<User> users = Arrays.asList(user1, user2, user3);

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    String name = Thread.currentThread().getName();
                    // System.out.println(name);
                    long index = Thread.currentThread().getId() % 3;
                    // String key = String.valueOf(index);
                    // String key = index + "";
                    // sync(name, new Server(index + ""));
                    // sync(name, key);
                    sync(name, index);
                }

            }).start();
        }
    }

    static class Server {
        private String serverId;

        public Server() {
        }

        public Server(String serverId) {
            this.serverId = serverId;
        }

        public String getServerId() {
            return serverId;
        }

        public void setServerId(String serverId) {
            this.serverId = serverId;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((serverId == null) ? 0 : serverId.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Server other = (Server) obj;
            if (serverId == null) {
                if (other.serverId != null)
                    return false;
            } else if (!serverId.equals(other.serverId))
                return false;
            return true;
        }

        // @Override
        // public String toString() {
        // return "Server [serverId=" + serverId + "]";
        // }

    }
}
