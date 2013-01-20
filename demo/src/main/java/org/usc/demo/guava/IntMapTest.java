package org.usc.demo.guava;

/**
 *
 */

import gnu.trove.map.hash.TObjectIntHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.AtomicLongMap;

/**
 * @author Administrator
 *
 */
public class IntMapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int cycles[] = { 100, 1000, 10000, 100000 };
        Tester baseLine = new BaseLine();
        Tester testForNull = new UseNullTest();
        Tester useAtomicLong = new UseAtomicLong();
        Tester useTrove = new UseTrove();
        Tester useMutableInt = new UseMutableInt();
        Tester useGuava = new UseGuava();
        Tester useGuava2 = new UseGuava2();

        for (int i = 0; i < cycles.length; i++) {
            System.out.println("-----With " + cycles[i] + " cycles-----");
            baseLine.test(cycles[i]);
            testForNull.test(cycles[i]);
            useAtomicLong.test(cycles[i]);
            useTrove.test(cycles[i]);
            useMutableInt.test(cycles[i]);
            useGuava.test(cycles[i]);
            useGuava2.test(cycles[i]);
            System.out.println("------------------------");
        }

    }

}

abstract class Tester {
    long ms;
    static String[] strs = "abcdefghijklmnopqrstuvwxyz".split("");

    void pre() {
        System.out.println("====" + this.getName() + "Test Case ");
        ms = System.currentTimeMillis();
        System.out.println("start at " + ms);
    }

    void post() {
        ms = System.currentTimeMillis() - ms;
        System.out.println("Time used: " + ms + " ms");
    }

    abstract void doAction(int cycles);

    public void test(int cycles) {
        pre();
        doAction(cycles);
        post();
    }

    abstract String getName();
}

class BaseLine extends Tester {
    final Map<String, Integer> freq = new HashMap<String, Integer>();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                int count = freq.containsKey(word) ? freq.get(word) : 0;
                freq.put(word, count + 1);
            }
        }
    }

    @Override
    String getName() {
        return "BaseLine";
    }

}

class UseNullTest extends Tester {
    final Map<String, Integer> freq = new HashMap<String, Integer>();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                Integer count = freq.get(word);
                if (count == null) {
                    freq.put(word, 1);
                } else {
                    freq.put(word, count + 1);
                }
            }
        }
    }

    @Override
    String getName() {
        return "TestForNull";
    }

}

class UseAtomicLong extends Tester {
    final ConcurrentMap<String, AtomicLong> map = new ConcurrentHashMap<String, AtomicLong>();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                map.putIfAbsent(word, new AtomicLong(0));
                map.get(word).incrementAndGet();
            }
        }
    }

    @Override
    String getName() {
        return "AtomicLong";
    }

}

class UseTrove extends Tester {
    final TObjectIntHashMap<String> freq = new TObjectIntHashMap<String>();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                freq.adjustOrPutValue(word, 1, 1);
            }
        }
    }

    @Override
    String getName() {
        return "Trove";
    }

}

class MutableInt {
    int value = 1; // note that we start at 1 since we're counting

    public void increment() {
        ++value;
    }

    public int get() {
        return value;
    }
}

class UseMutableInt extends Tester {
    Map<String, MutableInt> freq = new HashMap<String, MutableInt>();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                MutableInt count = freq.get(word);
                if (count == null) {
                    freq.put(word, new MutableInt());
                } else {
                    count.increment();
                }
            }
        }
    }

    @Override
    String getName() {
        return "MutableInt";
    }

}

class UseGuava extends Tester {
    AtomicLongMap<String> map = AtomicLongMap.create();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                map.getAndIncrement(word);
            }
        }
    }

    @Override
    String getName() {
        return "Guava AtomicLongMap";
    }

}

class UseGuava2 extends Tester {
    Multiset<String> bag = HashMultiset.create();

    @Override
    void doAction(int cycles) {
        for (int i = 0; i < cycles; i++) {
            for (String word : strs) {
                bag.add(word);
            }
        }
    }

    @Override
    String getName() {
        return "Guava HashMultiSet";
    }

}
