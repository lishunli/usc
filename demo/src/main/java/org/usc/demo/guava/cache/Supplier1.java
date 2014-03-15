package org.usc.demo.guava.cache;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Shunli
 */
public class Supplier1 extends AbstractSupplier<String> {

    @Override
    protected String loadCache() {
        return "S1-" + RandomStringUtils.randomAlphanumeric(6);
    }

}
