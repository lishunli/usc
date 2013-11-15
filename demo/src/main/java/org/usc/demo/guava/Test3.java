package org.usc.demo.guava;

import java.math.RoundingMode;
import java.util.Arrays;

import com.google.common.base.Objects;
import com.google.common.math.IntMath;

public class Test3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object[] objs = { "1", 2 };

        System.out.println(objs);
        System.out.println(Arrays.toString(objs));
        System.out.println(Objects.toStringHelper(objs).toString());

        System.out.println(IntMath.divide(10, 5, RoundingMode.UP));
    }

}
