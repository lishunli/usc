package org.usc.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.taifook.mtss.mss.common.util.DateTimeUtils;

/**
 *
 * @author ShunLi
 */
public class T3 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-01");

        Calendar canlendar = Calendar.getInstance();
        canlendar.setTime(DateTimeUtils.parse(dateFormat.format(new Date())));
        canlendar.add(Calendar.DATE, -1);

        Date lastMonthLastDay = canlendar.getTime();
        Date lastMonthFirstDay = DateTimeUtils.parse(dateFormat.format(lastMonthLastDay));

        System.out.println(lastMonthFirstDay);
        System.out.println(lastMonthLastDay);

    }

}
