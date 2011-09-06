package org.usc.demo;

import java.util.Scanner;

/**
 *
 * @author ShunLi
 */
public class CalcAllowance {
    public static void main(String[] args) {
        int i = 0;
        while (i++ < 10) {
            System.out.print("please input dates: ");

            Scanner input = new Scanner(System.in);
            int days = input.nextInt(); // read from file,and -, + 1
            float base = 50f;// read from file
            float step = 10f;// read from file

            System.out.println(calcAllowance(days, base, step));
        }

    }

    public static float calcAllowance(int days, float base, float step) {
        int dayOfMonth = 30;

        int factor = 1;
        float allowance = 0f;

        for (; days > dayOfMonth; factor++, days -= dayOfMonth) {
            allowance += dayOfMonth * (base + step * (factor - 1)); //calc before level
        }
        allowance += days * (base + step * (factor - 1)); // calc current level

        return allowance;
    }

}
