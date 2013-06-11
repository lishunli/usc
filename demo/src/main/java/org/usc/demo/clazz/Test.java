package org.usc.demo.clazz;

/**
 *
 * @author Shunli
 */
public class Test {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // new Child1().doAction();
        Child2 child2 = new Child2();
        child2.doAction();
        child2.doAction();

        // int count = 500000000;
        // long start = System.currentTimeMillis();
        // for (int i = 0; i < count; i++) {
        // new Child2().doAction();
        // }
        // System.out.println("Child1-" + (System.currentTimeMillis() - start));
        //
        //
        //
        // start = System.currentTimeMillis();
        // for (int i = 0; i < count; i++) {
        // new Child1().doAction();
        // }
        // System.out.println("Child1-" + (System.currentTimeMillis() - start));

        // Thread.sleep(1000);
    }

}
