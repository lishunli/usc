package org.usc.demo.lock;

/**
 *
 * @author Shunli
 */
@SuppressWarnings("unused")
public class SyncLockTest {

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		test4();
	}

	private static void test1() {
		String userId = "4800000000122";
		try {
			System.out.println(SyncLock.lock(userId));
			throw new RuntimeException();
		} catch (Exception e) {
		} finally {
			SyncLock.unlock(userId);
		}
		System.out.println(SyncLock.lock(userId));

	}

	private static void test2() {
		testOther();
	}

	private static void test3() {
		SyncLock.lock("TEST3", "123456");
	}

	private static void test4() {
		int j = 0;

		String userId = "4800000000122";
		MyThread thread = new MyThread(userId);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			new Thread(thread).start();
		}
	}

	private static void testOther() {
		SyncLock.lock("123456");
	}

}

class MyThread implements Runnable {
	private int count;
	private String userId;

	public MyThread(String userId) {
		this.userId = userId;
	}

	public void run() {
		if (SyncLock.lock(userId)) {
			System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
		} else {
			if ((count++) % 10000 == 0) {
				System.out.print("#");
			}
		}
	}
}
