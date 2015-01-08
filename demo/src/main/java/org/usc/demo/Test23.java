package org.usc.demo;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Shunli
 */
public class Test23 {
    private static final DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String startTime = "2014-12-17 00:00:00";
        String endTime = "2014-12-31 00:00:00";

        System.out.println(getCurrentDay(startTime, endTime));
    }

    private static DateTime getCurrentDay(String startTime, String endTime) {
        DateTime start = DateTime.parse(startTime, pattern);
        DateTime end = DateTime.parse(endTime, pattern);
        if (!start.isBeforeNow()) {
            return start;
        }

        DateTime now = DateTime.now();
        Interval inteval = new Interval(start, end);
        return now;
    }
}
