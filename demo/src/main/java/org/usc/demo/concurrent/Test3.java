package org.usc.demo.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Shunli
 */
public class Test3 {
	private static final Random random = new Random();

	public static void main(String[] args) {
		final List<User> users = Arrays.asList(new User("li1"), new User("li2"), new User("li3"), new User("li4"));

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						User user = users.get(random.nextInt(4));
						user.doSomething(Thread.currentThread().getName());
					}
				}
			}).start();
		}

	}

}

class User {
	private String userName;

	public User() {
	}

	public User(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void doSomething(String threadName) {
		synchronized (this) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + "," + userName + "," + System.currentTimeMillis());
		}
	}

}
