package org.usc.demo.time;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author ShunLi
 */
public class T5 {
    public static void main(String[] args) {
        Calendar inputDateFrom = new GregorianCalendar(2010, 6, 7, 10, 10);// 2010-07-07
        // Calendar inputDateTo = new GregorianCalendar(2010, 6, 30);// 2010-07-07
        // Calendar inputDateTo = null;
        // System.out.println(cal.getTime());
        // System.out.println(DateUtils.addDays(cal.getTime(), 70));

        // System.out.println(inputDateFrom == null ^ inputDateTo == null);

        // System.out.println(DateUtils.truncate(inputDateFrom, Calendar.MONTH).getTime());
        // System.out.println(DateUtils.truncate(inputDateTo, Calendar.MONTH).getTime());
        // System.out.println(DateUtils.truncate(inputDateFrom, Calendar.MONTH).getTime().equals(DateUtils.truncate(inputDateTo, Calendar.MONTH).getTime()));
        // System.out.println(String.format("SOD Cash %s Check.txt", new SimpleDateFormat("yyyyMMdd").format(new Date())));
        // MessageFormat.format("SOD Cash {0} Check.txt", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        // String.format("SOD Cash %s Check.txt", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        // System.out.println();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a", Locale.ENGLISH).format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.ENGLISH).format(inputDateFrom.getTime()));

    }
}
