package org.usc.demo.lock;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class SyncLock {
	private static final Map<String, Long> lockMap = new HashMap<String, Long>();
	private static final String SYNC_LOCK_DEFAULT_KEY_PREFIX = "ACT_SYNC_LOCK_";

	public synchronized static boolean lock(String key, Object field) {
		String keyWord = buildKeyWord(key, field);

		Long expiryTime = lockMap.get(keyWord);
		long currentTimeMillis = System.currentTimeMillis();
		if (expiryTime != null && currentTimeMillis < expiryTime) {
			return false;
		} else {
			lockMap.put(keyWord, currentTimeMillis + 10 * 1000L); // 60s
			return true;
		}
	}

	public static boolean lock(Object field) {
		return lock(buildCallMethodUID(), field);
	}

	public static void unlock(String key, Object field) {
		lockMap.remove(buildKeyWord(key, field));
	}

	public static void unlock(Object field) {
		unlock(buildCallMethodUID(), field);
	}

	private static String buildCallMethodUID() {
		String uid = "";
		try {
			// System.out.println(Thread.currentThread().getStackTrace().length);
			StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
			// System.out.println(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
			uid = (stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()).hashCode() + "";
		} catch (Exception e) {
		}
		return uid;
	}

	private static String buildKeyWord(String key, Object field) {
		String keyWord = SYNC_LOCK_DEFAULT_KEY_PREFIX;

		if (StringUtils.isNotEmpty(key)) {
			keyWord = keyWord + key + "_";
		}

		if (field != null && StringUtils.isNotEmpty(field.toString())) {
			keyWord += field.toString();
		}
		// System.out.println(keyWord);
		return keyWord;
	}
}
