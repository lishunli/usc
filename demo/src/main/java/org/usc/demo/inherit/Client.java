package org.usc.demo.inherit;

import java.util.Collections;
import java.util.HashMap;

import org.apache.commons.collections.map.LinkedMap;

/**
 *
 * @author ShunLi
 */
public class Client {
    public static void main(String[] args) {

        invoke1();
        System.out.println("I am SupperMan");
        invoke2();

    }

    private static void invoke1() {
        Father f = new Father();
        HashMap<String, String> map = new HashMap<String, String>();
        f.convert(map);

        Son s = new Son();
        s.convert(map);

        s.convert(new LinkedMap());
    }

    private static void invoke2() {
        Foo foo = new Foo();
        foo.convert(Collections.EMPTY_MAP);

        Child child = new Child();
        child.convert(Collections.EMPTY_MAP);

        child.convert(new HashMap<String, String>());
    }

}
