package org.usc.demo.beanutils.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.Converter;

/**
 * Beanutils String -> Map<String,String>
 *
 * @author Shunli
 */
public class SimpleMapConverter implements Converter {
    private final static char delimiter = '=';
    private final static char[] allowedChars = new char[] { '.', '-', '|' };

    private Object defaultValue = null;

    public SimpleMapConverter() {
    }

    public SimpleMapConverter(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Object convert(Class type, Object value) {
        if (type == null) {
            throw new IllegalArgumentException("type is missing");
        }

        if (!Map.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException("type must be a map");
        }

        if (value == null) {
            return defaultValue;
        }

        if (value instanceof Map) {
            return value;
        }

        Map<String, String> map = new HashMap<String, String>();

        // 1st convert to list
        List<String> convertToStringList = ConvertUtil.convertToStringList(value.toString());
        for (String string : convertToStringList) {
            // 2nd convert to map
            List<String> parseList = ConvertUtil.parseElements(string, delimiter, allowedChars);
            if (parseList.size() >= 2) {
                map.put(parseList.get(0), parseList.get(1));
            }
        }

        return map;
    }
}
