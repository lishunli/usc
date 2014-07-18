package org.usc.demo.lock;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class SyncLockUtil {
    public static String buildKeyWord(String key, Object field) {
        return StringUtils.join(key, "_", field);
    }
}
