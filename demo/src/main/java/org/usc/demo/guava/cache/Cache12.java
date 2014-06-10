package org.usc.demo.guava.cache;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.cache.CacheBuilder;

/**
 *
 * @author Shunli
 */
public class Cache12 extends AbstractCache1<String, String> {
    protected Cache12() {

    }

    // with expiry
    @Override
    protected CacheBuilder<Object, Object> newBuilder() {
        return super.newBuilder().weakKeys().softValues().expireAfterWrite(2, TimeUnit.SECONDS);
    }

    @Override
    protected String loadCache(String key) throws Exception {
        return "C12-" + RandomStringUtils.randomAlphanumeric(6);
    }

}
