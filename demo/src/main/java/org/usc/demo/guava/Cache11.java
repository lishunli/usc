package org.usc.demo.guava;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class Cache11 extends AbstractCache1<String, String> {
    // private static class Holder {
    // private static final Cache11 INSTANCE = new Cache11();
    // }
    //
    // private Cache11() {
    // }
    //
    // public static final Cache11 getInstance() {
    // return Holder.INSTANCE;
    // }

    @Override
    protected String loadCache(String key) throws Exception {
        return "C11-" + RandomStringUtils.randomAlphanumeric(6);
    }

}
