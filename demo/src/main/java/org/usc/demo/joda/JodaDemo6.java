package org.usc.demo.joda;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public class JodaDemo6 {
    private static final DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private static Supplier<RangeMap<DateTime, BatConfig>> newSupplier() {
        return Suppliers.memoize(
                new Supplier<RangeMap<DateTime, BatConfig>>() {
                    @Override
                    public RangeMap<DateTime, BatConfig> get() {
                        String startTime = "2014-10-01 00:00:00";
                        String midTime = "2014-10-08 00:00:00";
                        String endTime = "2014-10-13 00:00:00";
                        BatConfig firstBatConfig = new BatConfig("1", startTime, midTime);
                        BatConfig secondBatConfig = new BatConfig("2", midTime, endTime);

                        DateTime mid = pattern.parseDateTime(midTime);

                        RangeMap<DateTime, BatConfig> rangeMap = TreeRangeMap.create();
                        rangeMap.put(Range.lessThan(mid), firstBatConfig);
                        rangeMap.put(Range.atLeast(mid), secondBatConfig);

                        System.out.println("log." + rangeMap);
                        return rangeMap;
                    }
                });
    }

    private static Supplier<RangeMap<DateTime, BatConfig>> supplier = newSupplier();

    public static BatConfig getBatConfig() {
        String startTime = "2014-10-01 00:00:00";
        String midTime = "2014-10-08 00:00:00";
        BatConfig defaultBatConfig = new BatConfig("1", startTime, midTime);

        RangeMap<DateTime, BatConfig> rangeMap = supplier.get();
        if (rangeMap == null) {
            return defaultBatConfig;
        }

        return Objects.firstNonNull(rangeMap.get(DateTime.now()), defaultBatConfig);
    }

    public static void main(String[] args) {
        System.out.println(getBatConfig());
    }
}

class BatConfig {
    private String batId;
    private String startTime;
    private String endTime;
    private String lotteryFileName;

    public BatConfig(String batId, String startTime, String endTime) {
        this.batId = batId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lotteryFileName = String.format("xxx_%s.txt", batId);
    }

    public String getBatId() {
        return batId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLotteryFileName() {
        return lotteryFileName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
