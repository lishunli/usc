package org.usc.demo.concurrent;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author Shunli
 */
public class Cache {
	private static ConcurrentHashMap<String, FutureTask<String>> cache = new ConcurrentHashMap<String, FutureTask<String>>();

	public static String getValue(String key) throws InterruptedException, ExecutionException {
		FutureTask<String> task = cache.get(key);
		if (task != null) {
			// System.out.println("hided in cache");
			return task.get();
		}

		Callable<String> callable = new Callable<String>() {
			public String call() throws Exception {
				return UUID.randomUUID().toString();
			}
		};

		FutureTask<String> newTask = new FutureTask<String>(callable);
		task = cache.putIfAbsent(key, newTask);

		if (task == null) {
			task = newTask;
			task.run();
		} else {
			// 还是有冲突，不能作为获取唯一的值的方法，这种方法可以放在 高并发 + 对象产生耗时多的情况
			System.out.println("catch it " + key + ":" + task.get());
		}

		return task.get();
	}

	public static void remove(String key) {
		cache.remove(key);
	}
	public static void clearCache() {
		cache.clear();
	}
}
