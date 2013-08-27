package org.usc.demo.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shunli
 */
public class NomralCache {
    private static final Map<String, List<String>> caches = new HashMap<String, List<String>>();

    public static synchronized String getKey(String giftId) {
        List<String> keys = caches.get(giftId);

        if (keys != null) {
            if (!keys.isEmpty()) {
                return keys.remove(0);
            }
        }

        keys = Service.getKeys(giftId);
        caches.put(giftId, keys);

        return keys.remove(0);
    }

}
