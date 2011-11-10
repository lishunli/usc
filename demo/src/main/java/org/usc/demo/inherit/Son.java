package org.usc.demo.inherit;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author ShunLi
 */
public class Son extends Father{
    @SuppressWarnings("rawtypes")
    Collection convert(Map map) {
        System.out.println("son invoke...");
        return map.values();
    }
}
