package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class ThreadTest1 {

	public static void doSomething() {
		System.out.println("start");

		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + "end");
			}
		}).start();

		System.out.println("end");
	}

	public static void main(String[] args) {
		doSomething();

	}

}
