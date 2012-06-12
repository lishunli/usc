package org.usc.demo.concurrent;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 via http://www.tbdata.org/archives/969
 *
 * @author Shunli
 */
public class Cache2 {
	private ConcurrentHashMap<String, ServerGroup> route2SG = null;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public Cache2() {
		route2SG = new ConcurrentHashMap<String, ServerGroup>();
	}
	public ServerGroup get(String routeKey) throws IOException {
		ServerGroup sg = null;
		try {
			lock.readLock().lock();
			sg = route2SG.get(routeKey);
			if (sg == null) {
				lock.readLock().unlock();
				lock.writeLock().lock();
				sg = route2SG.get(routeKey);
				if (sg == null) {
					sg = getServerGroup(routeKey);
					route2SG.put(routeKey, sg);
				}
				lock.readLock().lock();
				lock.writeLock().unlock();
			}
		} catch (IOException e) {
			lock.writeLock().unlock();
			throw (e);
		}
		lock.readLock().unlock();
		return sg;
	}
	public void remove(String routeKey) {
		try {
			lock.writeLock().lock();
			route2SG.remove(routeKey);
		} finally {
			lock.writeLock().unlock();
		}
	}
	private ServerGroup getServerGroup(String routeKey) throws IOException {
		ServerGroup sg = null;
		/** * Construct ServerGroup here */
		return sg;
	}
}
