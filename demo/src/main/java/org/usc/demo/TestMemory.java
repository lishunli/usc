package org.usc.demo;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {
    public static void main(String[] args) {
        List<Long> testMemory = new ArrayList<Long>();

        if (testMemory.isEmpty()) {
            testMemory.add(0L);
        }

        if (testMemory.size() < Integer.MAX_VALUE - 1000000) {
            int start = testMemory.size() - 1;
            for (int i = 0; i < 1000000; i++) {
                testMemory.add((long) (start + i));
            }
        }
    }
}
