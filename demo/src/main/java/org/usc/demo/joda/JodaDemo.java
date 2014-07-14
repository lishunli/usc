package org.usc.demo.joda;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

/**
 *
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-6-25<br>
 *        Revision of last commit:$Revision: 1625 $<br>
 *        Author of last commit:$Author: lishunli.me@gmail.com $<br>
 *        Date of last commit:$Date: 2013-11-15 17:57:35 +0800 (Fri, 15 Nov 2013) $<br>
 *        <p>
 */
public class JodaDemo {
    public static void main(String[] args) {
//        DateTime dt = new DateTime(2010, 3, 18, 12, 25, 52, 0);
//
//        System.out.println(dt);
//
//        System.out.println(dt.minuteOfDay().get());
//
//        System.out.println(dt.minusMonths(1).dayOfMonth().roundCeilingCopy());
//        System.out.println(dt.minusMonths(1).dayOfMonth().withMaximumValue());
//
//        System.out.println(dt.getChronology());
//
//        dt.plusDays(1);
//
//        System.out.println(dt.withDayOfMonth(1).withMillisOfDay(0));
//        System.out.println(dt.monthOfYear().roundFloorCopy());
//
//        String monthName = dt.monthOfYear().getAsText();
//        String frenchShortName = dt.monthOfYear().getAsShortText(Locale.FRENCH);
//        boolean isLeapYear = dt.year().isLeap();
//        DateTime rounded = dt.dayOfMonth().roundFloorCopy();
//
//        System.out.println(monthName);
//        System.out.println(frenchShortName);
//        System.out.println(isLeapYear);
//        System.out.println(rounded);

        DateTime start = new DateTime(2011, 12, 2, 15, 33);// 开始时间
        DateTime end = new DateTime(2013, 8, 1, 12, 34);// 结束时间
        Interval inteval = new Interval(start, end);
        System.out.println(inteval.containsNow());


        System.out.println("Interval = " + inteval);

        //
        // Gets the duration of this time interval
        //
        Duration duration = inteval.toDuration();

        System.out.println("Duration = " + duration);
    }

}
