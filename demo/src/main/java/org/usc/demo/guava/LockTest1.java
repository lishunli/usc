package org.usc.demo.guava;

import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.collect.Lists;

/**
 *
 * @author Shunli
 */
public class LockTest1 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Object> newCopyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
        System.out.println(newCopyOnWriteArrayList.addIfAbsent("1212"));
        System.out.println(newCopyOnWriteArrayList.addIfAbsent("1212"));

        System.out.println(newCopyOnWriteArrayList.remove("1212"));
    }

}
