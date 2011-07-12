package org.usc.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author ShunLi
 */
public class T2 {
    public static void main(String[] args) {
        String sample1 = "org.apache.catalina.startup.HostConfig deployDirectory";
        String sample2 = "org.apache";

        System.out.println(StringUtils.split(sample1, ".", 3));;
        System.out.println(StringUtils.split(sample2, ".", 3));;

        Calendar cal = new GregorianCalendar(2010, 6, 7);// 2010-07-07
        System.out.println(cal.getTime());
//        System.out.println(DateUtils.addDays(cal.getTime(), 70));

        cal.roll(Calendar.DATE, true);
        System.out.println(cal.getTime());

        Date lastMonthLastDay = DateUtils.addDays(DateUtils.truncate(new Date(), Calendar.MONTH), -1);
        Date lastMonthFirstDay = DateUtils.truncate(lastMonthLastDay, Calendar.MONTH);

        System.out.println(lastMonthLastDay);
        System.out.println(lastMonthFirstDay);

    }

}
