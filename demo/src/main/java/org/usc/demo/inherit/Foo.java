package org.usc.demo.inherit;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author ShunLi
 */
public class Foo {
    @SuppressWarnings("rawtypes")
    Collection convert(Map map) {
        System.out.println("foo invoke...");
        return map.values();
    }
}
