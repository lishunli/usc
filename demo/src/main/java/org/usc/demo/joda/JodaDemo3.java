package org.usc.demo.joda;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
public class JodaDemo3 {

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        LocalDate localDate = dtf.parseLocalDate("2014-03-01");
        int days = Days.daysBetween(LocalDate.now(), localDate).getDays();
        System.out.println(days);

        DateTime now = DateTime.now();
        // begin of a day
        System.out.println(now.withTimeAtStartOfDay());

        DateTime start = new DateTime(2014, 3, 18, 12, 25, 52, 0);
        System.out.println(Hours.hoursBetween(start, now).getHours());

    }

}
