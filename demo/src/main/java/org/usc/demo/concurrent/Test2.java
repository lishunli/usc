package org.usc.demo.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Shunli
 */
public class Test2 {
//	private static final ReadWriteLock lock = new ReentrantReadWriteLock();
	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
	static {
		int i = 0;
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
		list.add("ddd" + (i++));
	}

	/**
	 * @param args
	 */
	static synchronized void method() {
		// if (list1.size() > 0) {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println(list1.remove(0));
		// }

		// lock.writeLock().lock();
		while (!list.isEmpty()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(list.remove(0));
			break;
		}
		// lock.writeLock().unlock();
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						method();
					}
				}
			}).start();
		}
		// System.out.println(list1.remove(0));
	}

}
