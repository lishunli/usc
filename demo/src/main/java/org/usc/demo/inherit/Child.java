package org.usc.demo.inherit;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author ShunLi
 */
public class Child extends Foo {
    @SuppressWarnings("rawtypes")
    Collection convert(HashMap map) {
        System.out.println("child invoke...");
        return map.values();
    }
}
