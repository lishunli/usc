package org.usc.demo;

/**
 *
 * @author ShunLi
 */
public class GetMethodNameTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GetMethodNameTest t = new GetMethodNameTest();
        t.getMethodName();
    }

    private void getMethodName() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println(new Exception().getStackTrace()[0].getMethodName());
        System.out.println(this.getClass().getDeclaredMethods()[1]);
    }
}
