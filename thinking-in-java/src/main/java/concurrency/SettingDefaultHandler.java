//: concurrency/SettingDefaultHandler.java
package concurrency; /* Added by Eclipse.py */

import java.util.concurrent.*;

public class SettingDefaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
} /*
 * Output: caught java.lang.RuntimeException
 */// :~
