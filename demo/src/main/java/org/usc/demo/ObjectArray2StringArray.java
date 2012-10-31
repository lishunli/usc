package org.usc.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ObjectArray2StringArray {

    public static void main(String[] args) {
        test1();
        String[] array = Arrays.asList("1", "2", "3").toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }

    private static void test1() {
        Object[] objArray = new Object[] { "1", "2" };

        int length = objArray.length;
        String[] dest = new String[length];

        for (int i = 0; i < length; i++) {
            dest[i] = objArray[i].toString();
        }

        System.out.println(Arrays.toString(dest));
    }

    public static <T> T[] toArray(List<T> list, Class<T> clazz) {
        if (list == null) {
            return null;
        }

        int size = list.size();
        @SuppressWarnings("unchecked")
        T[] t = (T[]) Array.newInstance(clazz, size);

        for (int i = 0; i < size; i++) {
            t[i] = list.get(i);
        }

        return t;
    }
}
