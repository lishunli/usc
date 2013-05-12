package org.usc.demo;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Shunli
 */
public class Test9 {

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            handleException(e);
        }

        // doSomething();
    }

    private static void handleException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        System.out.println(stackTrace[0].getMethodName());
        System.out.println(stackTrace[stackTrace.length - 1].getMethodName());
        // System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        // System.out.println(new Throwable().getStackTrace()[1].getMethodName());
        // System.out.println(new Exception().getStackTrace()[1].getMethodName());
        getCallerMethodName();

    }

    private static void doSomething() {
        doSomethingDeepOne();
    }

    private static void doSomethingDeepOne() {
        doSomethingDeepTwo();
    }

    private static void doSomethingDeepTwo() {
        doSomethingDeepThree();
    }

    private static void doSomethingDeepThree() {
        throw new IllegalArgumentException("test");
    }

    private static String getCallerMethodName() {
        System.out.println("============");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println(new Throwable().getStackTrace()[2].getMethodName());
        System.out.println(new Exception().getStackTrace()[2].getMethodName());


        return "";
    }
}
