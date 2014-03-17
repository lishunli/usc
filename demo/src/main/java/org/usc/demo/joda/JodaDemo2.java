package org.usc.demo.joda;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 *
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-6-25<br>
 *        Revision of last commit:$Revision: 1604 $<br>
 *        Author of last commit:$Author: lishunli.me@gmail.com $<br>
 *        Date of last commit:$Date: 2013-02-28 16:46:58 +0800 (周四, 28 二月 2013) $<br>
 *        <p>
 */
public class JodaDemo2 {

    public static void main(String[] args) throws ParseException {
        int startHourOfDay = 13;
        int startMinuteOfHour = 0;
        int endHourOfDay = 21;
        int endMinuteOfHour = 0;

        DateTime now = DateTime.now();
        DateTime startTime = now.withTime(startHourOfDay, startMinuteOfHour, 0, 0);
        DateTime endTime = now.withTime(endHourOfDay, endMinuteOfHour, 0, 0);
        System.out.println(startTime);
        System.out.println(endTime);

        Interval inteval = new Interval(startTime, endTime);
        System.out.println(inteval.containsNow());

    }

}
