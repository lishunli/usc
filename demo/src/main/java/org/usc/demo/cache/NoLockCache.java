package org.usc.demo.cache;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 *
 * @author Shunli
 */
public class NoLockCache {
    private static ConcurrentHashMap<String, FutureTask<List<String>>> caches = new ConcurrentHashMap<String, FutureTask<List<String>>>();

    public static String getKey(String giftId) {
        try {
            FutureTask<List<String>> ft = caches.get(giftId);
            if (ft != null) {
                List<String> keys = ft.get();

                if (!keys.isEmpty()) {
                    return keys.remove(0);
                }
            }

            FutureTask<List<String>> sft = new FutureTask<List<String>>(new ConstructTask(giftId));
            FutureTask<List<String>> old = caches.putIfAbsent(giftId, sft);
            if (old == null) {
                old = sft;
                old.run();
            }

            List<String> keys = old.get();

            if (!keys.isEmpty()) {
                return keys.remove(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static class ConstructTask implements Callable<List<String>> {
        private final String giftId;

        public ConstructTask(String giftId) {
            super();
            this.giftId = giftId;
        }

        public List<String> call() throws Exception {
            return Service.getKeys(giftId);
        }
    }
}
