package org.usc.demo.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Shunli
 */
public class Test {
	private static final Random random = new Random();

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// for (int i = 0; i < 100; i++) {
		// String key = random.nextInt(10) + "";
		// System.out.println(key + ":" + Cache.getValue(key));
		// }
		Cache.clearCache();

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							String key = random.nextInt(10) + "";
							key = Thread.currentThread().getName() + "-" + key + ":" + Cache.getValue(key);
							System.out.println(key);
//							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
}
