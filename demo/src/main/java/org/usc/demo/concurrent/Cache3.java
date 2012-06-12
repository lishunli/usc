package org.usc.demo.concurrent;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 并发加锁 via http://www.tbdata.org/archives/969
 *
 * @author Shunli
 */
public class Cache3 {
	private ConcurrentHashMap<String, FutureTask<ServerGroup>> route2SGFT = null;

	public Cache3() {
		route2SGFT = new ConcurrentHashMap<String, FutureTask<ServerGroup>>();
	}

	public ServerGroup get(String routeKey) throws IOException, InterruptedException, ExecutionException {
		FutureTask<ServerGroup> ft = route2SGFT.get(routeKey);
		if (ft != null) {
			return ft.get();
		}
		FutureTask<ServerGroup> sft = new FutureTask<ServerGroup>(new ConstructSGTask(routeKey));
		FutureTask<ServerGroup> old = route2SGFT.putIfAbsent(routeKey, sft);
		if (old == null) {
			old = sft;
			old.run();
		}
		return old.get();
	}

	public void remove(String routeKey) {
		route2SGFT.remove(routeKey);
	}

	class ConstructSGTask implements Callable<ServerGroup> {
		private final String key;

		public ConstructSGTask(String key) {
			super();
			this.key = key;
		}

		public ServerGroup call() throws Exception {
			return getServerGroup(key);
		}
	}

	private ServerGroup getServerGroup(String routeKey) throws IOException {
		ServerGroup sg = null;
		/** * Construct ServerGroup here */
		return sg;
	}
}
