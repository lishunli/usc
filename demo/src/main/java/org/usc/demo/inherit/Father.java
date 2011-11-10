package org.usc.demo.inherit;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author ShunLi
 */
public class Father {
    @SuppressWarnings("rawtypes")
    Collection convert(HashMap map) {
        System.out.println("father invoke...");
        return map.values();
    }
}
