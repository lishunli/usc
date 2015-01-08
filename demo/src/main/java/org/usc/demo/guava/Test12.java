package org.usc.demo.guava;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 *
 * @author Shunli
 */

public class Test12 {
    // private static final int count = 10000000;
    private static final Function<Thing, String> keyFunction = new Function<Thing, String>() {
        @Override
        public String apply(Thing input) {
            return input.getId();
        }
    };

    public static void main(String[] args) {
        List<Thing> things = ImmutableList.of(new Thing("1", 1), new Thing("2", 2), new Thing("3", 3), new Thing("4", 4));

        Map<String, String> maps = ImmutableMap.of("1", "v1", "2", "v2", "3", "v3", "4", "v4");

        // method1
        Stopwatch sw1 = Stopwatch.createStarted();
        // for (int i = 0; i < count; i++) {
        for (Entry<String, String> entry : maps.entrySet()) {
            final String key = entry.getKey();
            String value = entry.getValue();

            Predicate<Thing> predicate = new Predicate<Thing>() {
                @Override
                public boolean apply(Thing input) {
                    return StringUtils.equals(input.getId(), key);
                }
            };
            Optional<Thing> tryFind = Iterables.tryFind(things, predicate);
            Thing orNull = tryFind.orNull();

            System.out.println("method 1:" + key + "," + value + "," + (orNull != null ? orNull.getPrice() : 0));
        }
        // }
        System.out.println("method 1 elapsed times:" + sw1.elapsed(TimeUnit.MILLISECONDS));

        // method2
        Stopwatch sw2 = Stopwatch.createStarted();
        // for (int i = 0; i < count; i++) {
        ImmutableMap<String, Thing> uniqueIndex = Maps.uniqueIndex(things, keyFunction);
        for (Entry<String, String> entry : maps.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Thing orNull = uniqueIndex.get(key);

            System.out.println("method 2:" + key + "," + value + "," + (orNull != null ? orNull.getPrice() : 0));
        }
        // }
        System.out.println("method 2 elapsed times:" + sw2.elapsed(TimeUnit.MILLISECONDS));

    }

}

class Thing {
    private String id;
    private int price;

    public Thing(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
