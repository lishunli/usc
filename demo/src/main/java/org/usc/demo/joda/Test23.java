package org.usc.demo.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.google.common.collect.Ordering;

/**
 *
 * @author Shunli
 */

public class Test23 {
    private static final DateTimeFormatter dateTimePattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String day = "2014-12-15";
        DateTime currentDate = getCurrentDateTime(day);
        DateTime now = DateTime.now();

        System.out.println(currentDate);
        System.out.println(now);

        if (currentDate.isBefore(now)) {
            System.out.println("cache from history(fixed)");
        } else if (currentDate.isEqual(now)) {
            System.out.println("cache from current cache(with expired time)");
        } else {
            System.out.println("empty-list/act not start");
        }

    }

    private static DateTime getCurrentDateTime(String day) {
        DateTime start = dateTimePattern.parseDateTime("2014-12-16 12:00:00");// 开始时间
        DateTime end = dateTimePattern.parseDateTime("2014-12-30 23:59:59");// 结束时间
        DateTime now = DateTime.now();

        if (!start.isBefore(now)) {
            return start;
        }

        DateTime minOfNowAndEnd = Ordering.natural().min(now, end);
        DateTime date = minOfNowAndEnd;
        try {
            date = ISODateTimeFormat.date().parseDateTime(day);
        } catch (Exception e) {
        }

        if (date.isBefore(start)) {
            return start;
        }

        if (date.isAfter(minOfNowAndEnd)) {
            return minOfNowAndEnd;
        }

        return date;
    }
}
