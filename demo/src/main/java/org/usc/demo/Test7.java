package org.usc.demo;

/**
 *
 * @author Shunli
 */
public class Test7 {

    public static void main(String[] args) {
        // Integer num = 2;
        // System.out.println(Integer.toBinaryString(num));
        // System.out.println(num.byteValue());

        // byte checkNum = ;
        // int checkOpt = 1;

        // 判断第几位是否是1（选中）
        int num = 11;
        for (int i = 1; i <= 8; i++) {
            System.out.println(i + ":" + ((num & (1 << (i - 1))) != 0));
        }

        // 判断是否是2的n次方，保证checkNum>0
        int checkNum = 1;
        System.out.println((checkNum & (checkNum - 1)) == 0);

    }
}
