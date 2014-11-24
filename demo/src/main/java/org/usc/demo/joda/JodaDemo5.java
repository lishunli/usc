package org.usc.demo.joda;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public class JodaDemo5 {
    private static final DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        DateTime start = pattern.parseDateTime("2014-10-01 00:00:00");// 开始时间
        DateTime mid = pattern.parseDateTime("2014-10-08 00:00:00");// 中间时间
        DateTime end = pattern.parseDateTime("2014-10-13 00:00:00");// 结束时间
        Interval inteval = new Interval(start, mid);

        System.out.println(inteval);

        Interval interval2 = new Interval(inteval.toDuration(), end);
        System.out.println(inteval);
        System.out.println(interval2);

//        //
//        // Gets the duration of this time interval
//        //
//        Duration duration = inteval.toDuration();
//
//        System.out.println("Duration = " + duration);

        // if now < mid, 第一期，开始结束时间 [start, mid)
        // else 第二期，开始结束时间 [mid,end)
        // BatConfig, startTime, endTime, batId, lotteryFileName
    }
}
