package org.usc.demo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Shunli
 */
public class Test13 {
    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String startTime = "2013-07-01 10:12:30";
        String endTime = "2013-07-04 13:00:10";
        System.out.println(calcTotal(startTime, endTime));
    }

    private static int calcTotal(String startTime, String endTime) {
        DateTime start = DateTime.parse(startTime, format);
        DateTime end = DateTime.parse(endTime, format);

        DateTime now = DateTime.now();
        DateTime yesterdayBegin = now.minusDays(1).dayOfMonth().roundFloorCopy();

        // System.out.println(start);
        // System.out.println(end);
        // System.out.println(now);
        // System.out.println(yesterdayBegin);

        if (start.isAfter(end) || start.isAfter(now)) {
            return 0;
        }

        if (end.isBefore(yesterdayBegin)) {
            // hist >= start <= end
            return 10;
        }

        DateTime minOfEndAndNow = now.isBefore(end) ? now : end;
        System.out.println(minOfEndAndNow);
        if (!start.isBefore(yesterdayBegin)) {
            // cur >= start <= min(end, now)
            return 20;
        }

        // hist >= start < yesterdayBegin
        // union
        // cur >= yesterdayBegin <= min(end, now)
        return 35;
    }
}
