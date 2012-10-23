package org.usc.demo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shunli
 */
public class IpAntiAttackUtil {
    private static Map<String, CacheEntry> ipCache = new HashMap<String, IpAntiAttackUtil.CacheEntry>();

    public static boolean isValidIp(String ip) {
        CacheEntry entry = ipCache.get(ip);
        long currentTimeMillis = System.currentTimeMillis();
        int threshold = 100;
        if (entry != null && currentTimeMillis <= entry.getExpiredTime()) {
            int times = entry.getTimes() + 1;

            if (times > threshold) {
                return false;
            }

            entry.setTimes(times);

            if (entry.getTimes() >= threshold) {
                entry.setExpiredTime(currentTimeMillis + 8 * 60 * 60 * 1000L);// 8h
                // log
            }
        } else {
            ipCache.put(ip, new CacheEntry(1, currentTimeMillis + 1 * 60 * 1000L));// 1min
        }

        return true;
    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        for (int i = 0; i < 1000; i++) {
            if (!isValidIp(ip)) {
                System.out.println("Warning!!! " + ip + " attack.");
            }
        }
    }

    private static class CacheEntry {
        private int times;
        private long expiredTime;

        public CacheEntry(int times, long expiredTime) {
            this.times = times;
            this.expiredTime = expiredTime;
        }

        public int getTimes() {
            return times;
        }
        public void setTimes(int times) {
            this.times = times;
        }
        public long getExpiredTime() {
            return expiredTime;
        }
        public void setExpiredTime(long expiredTime) {
            this.expiredTime = expiredTime;
        }
    }

}
