package org.usc.demo.joda;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.google.common.collect.Ordering;

/**
 *
 * @author Shunli
 */

public class Test24 {
    private static final DateTimeFormatter dateTimePattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String day = "2014-12-15";
        LocalDate currentDate = getCurrentDate(day);
        LocalDate now = LocalDate.now();

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

    private static LocalDate getCurrentDate(String day) {
        LocalDate start = dateTimePattern.parseLocalDate("2014-12-15 00:00:00");// 开始时间
        LocalDate end = dateTimePattern.parseLocalDate("2014-12-30 23:59:59");// 结束时间
        LocalDate now = LocalDate.now();

        if (!start.isBefore(now)) {
            return start;
        }

        LocalDate minOfNowAndEnd = Ordering.natural().min(now, end);
        LocalDate date = minOfNowAndEnd;
        try {
            date = ISODateTimeFormat.date().parseLocalDate(day);
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
