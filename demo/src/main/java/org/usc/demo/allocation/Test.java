package org.usc.demo.allocation;


/**
 *
 * @author ShunLi
 */
public class Test {

    public static void main(String[] args) {
        // String a = "a";
        // String b = a;
        // System.out.println( a == b);
        //
        // int i1 = 127;
        // int i2 = 127;
        // System.out.println(i1 == i2);
        //
        // int i3 = 129;
        // int i4 = 129;
        // System.out.println(i3 == i4);

        // GroupAcInfo info1 = new GroupAcInfo("1", BigDecimal.ONE);
        // GroupAcInfo info2 = info1;
        // GroupAcInfo info3 = info1;
        // System.out.println(info1 == info2);
        // System.out.println(info1 == info3);
        //
        // info1 = null;
        // System.out.println(info3 == info2);
        //
        // System.out.println(info1);
        // System.out.println(info2);
        // System.out.println(info3);
        //
        // System.gc();
        // System.out.println(info1);
        // System.out.println(info2);
        // System.out.println(info3);

        // List<String> list1 = new ArrayList<String>();
        // List<String> list2 = list1;
        //
        // System.out.println(list1 == list2);
        // System.out.println(list1);
        // System.out.println(list2);
        // list1 = null;
        // System.out.println(list1);
        // System.out.println(list2);

        int a = 5;
        int b = 20;
        a = b;
        System.out.println(a);

    }

}
