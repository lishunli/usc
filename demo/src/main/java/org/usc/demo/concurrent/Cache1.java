package org.usc.demo.concurrent;

import java.io.IOException;
import java.util.HashMap;

/**
 * 粗放的加锁 via http://www.tbdata.org/archives/969
 *
 * @author Shunli
 */
public class Cache1 {
	private HashMap<String, ServerGroup> route2SG = null;

	public Cache1() {
		route2SG = new HashMap<String, ServerGroup>();
	}
	public synchronized ServerGroup get(String routeKey) throws IOException {
		ServerGroup sg = null;
		sg = route2SG.get(routeKey);
		if (sg == null) {
			sg = getServerGroup(routeKey);
			route2SG.put(routeKey, sg);
		}
		return sg;
	}

	private ServerGroup getServerGroup(String routeKey) throws IOException {
		ServerGroup sg = null;
		/** * Construct ServerGroup here */
		return sg;
	}
}
