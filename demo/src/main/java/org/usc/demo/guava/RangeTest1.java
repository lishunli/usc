package org.usc.demo.guava;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 *
 * @author Shunli
 */
public class RangeTest1 {
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static final Splitter splitter = Splitter.on("|").omitEmptyStrings().trimResults();
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
                List<String> configInfos = ImmutableList.of("1|2014-10-01|2014-10-08|1000", "2|2014-10-10|2014-10-18|1000", "3|2014-11-24|2014-12-05|3000");

                Map<String, Config> configMap = Maps.newHashMap();
                for (String info : configInfos) {
                    List<String> splitToList = splitter.splitToList(info);

                    String id = splitToList.get(0);
                    String startTime = splitToList.get(1);
                    String endTime = splitToList.get(2);
                    String giftId = splitToList.get(3);

                    configMap.put(id, new Config(id, startTime, endTime, giftId));
                }

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

class Config {
    private String id;
    private String startTime;
    private String endTime;
    private String giftId;

    public Config(String id, String startTime, String endTime, String giftId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.giftId = giftId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
