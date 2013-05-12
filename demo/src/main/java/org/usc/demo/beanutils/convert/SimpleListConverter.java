package org.usc.demo.beanutils.convert;

import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.Converter;

/**
 * Beanutils String -> List<String>
 *
 * @author Shunli
 */
public class SimpleListConverter implements Converter {
    private Object defaultValue = null;

    public SimpleListConverter() {
    }

    public SimpleListConverter(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Object convert(Class type, Object value) {
        if (type == null) {
            throw new IllegalArgumentException("type is missing");
        }

        if (!List.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException("type must be a list");
        }

        if (value == null) {
            return defaultValue;
        }

        if (value instanceof Collection) {
            return value;
        }

        // Deal with a null value
        return ConvertUtil.convertToStringList(value.toString());
    }

}
