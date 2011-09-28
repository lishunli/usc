package com.googlecode.usc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author ShunLi
 */
public class UtilsTest {

    @Test
    public void testIsBlank() {
        String demo1 = null;
        assertTrue(Utils.isBlank(demo1));

        String demo2 = "";
        assertTrue(Utils.isBlank(demo2));

        String demo3 = "demo";
        assertFalse(Utils.isBlank(demo3));
    }

    //TODO: add other unit tests.
}
