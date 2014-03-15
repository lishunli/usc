package org.usc.demo.guava.cache;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 *
 * @author Shunli
 */
public class Supplier2 extends AbstractSupplier<String> {
    @Override
    protected Supplier<String> newSupplier() {
        return Suppliers.memoizeWithExpiration(load(), 2, TimeUnit.SECONDS);
    }

    @Override
    protected String loadCache() {
        return "S2-" + RandomStringUtils.randomAlphanumeric(6);
    }

}
