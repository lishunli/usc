package org.usc.demo.guava;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter.MapSplitter;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 *
 * @author Shunli
 */
public class RangeTest2 {
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static final Splitter splitter = Splitter.on("/").omitEmptyStrings().trimResults();
    private static final MapSplitter mapSplitter = Splitter.on("|").withKeyValueSeparator("=");
    private static final Ordering<Config> ordering = new Ordering<Config>() {
        @Override
        public int compare(Config left, Config right) {
            return ComparisonChain.start()
                    .compare(left.getStartTime(), right.getStartTime(), Ordering.natural().reverse().nullsFirst())
                    .compare(left.getEndTime(), right.getEndTime(), Ordering.natural().reverse().nullsFirst())
                    .result();
        }
    };

    private static Supplier<Map<String, Config>> buildConfigMapSupplier() {
        return Suppliers.memoize(new Supplier<Map<String, Config>>() {
            @Override
            public Map<String, Config> get() {
                String configString = "1=2014-10-01/2014-10-08/1000|2=2014-10-10/2014-10-18/1000|3=2014-11-24/2014-12-05/3000";
                Map<String, Config> configMap = Maps.transformEntries(mapSplitter.split(configString),
                        new EntryTransformer<String, String, Config>() {
                            @Override
                            public Config transformEntry(String key, String value) {
                                List<String> splitToList = splitter.splitToList(value);

                                String id = key;
                                String startTime = splitToList.get(0);
                                String endTime = splitToList.get(1);
                                String giftId = splitToList.get(2);

                                return new Config(id, startTime, endTime, giftId);
                            }
                        });

                System.out.println("load-Map");
                return configMap;
            }
        });
    }

    private static Supplier<RangeMap<DateTime, Config>> buildConfigRangeSupplier() {
        return Suppliers.memoize(new Supplier<RangeMap<DateTime, Config>>() {
            @Override
            public RangeMap<DateTime, Config> get() {
                boolean isFirst = true;
                RangeMap<DateTime, Config> rangeMap = TreeRangeMap.create();
                for (Config config : ordering.sortedCopy(configMapCache.get().values())) {
                    if (isFirst) {
                        rangeMap.put(Range.<DateTime> all(), config);

                        isFirst = false;
                    } else {
                        rangeMap.put(Range.lessThan(DateTime.parse(config.getEndTime(), formatter)), config);
                    }
                }

                System.out.println("load-Range");
                return rangeMap;
            }
        });
    }

    private static Supplier<Map<String, Config>> configMapCache = buildConfigMapSupplier();
    private static Supplier<RangeMap<DateTime, Config>> configRangeCache = buildConfigRangeSupplier();

    private static Config getConfig(String id) {
        if (StringUtils.isEmpty(id)) {
            return getConfig();
        }

        Config config = configMapCache.get().get(id);
        return config != null ? config : getConfig();
    }

    private static Config getConfig() {
        return configRangeCache.get().get(DateTime.now());
    }

    public static void main(String[] args) {
        System.out.println(getConfig());
        System.out.println(getConfig(null));
        System.out.println(getConfig(""));
        System.out.println(getConfig("1"));
        System.out.println(getConfig("2"));
        System.out.println(getConfig("3"));
        System.out.println(getConfig("4"));

    }

}
