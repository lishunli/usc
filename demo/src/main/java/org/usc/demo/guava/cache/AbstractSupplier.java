package org.usc.demo.guava.cache;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 *
 * @author Shunli
 */
public abstract class AbstractSupplier<V> {
    protected abstract V loadCache();

    protected Supplier<V> load() {
        return new Supplier<V>() {
            @Override
            public V get() {
                return loadCache();
            }
        };
    }

    protected Supplier<V> supplier = newSupplier();

    protected Supplier<V> newSupplier() {
        return Suppliers.memoize(load());
    }

    public V get() {
        return supplier.get();
    }

    public void refresh() {
        supplier = newSupplier();
    }

}
