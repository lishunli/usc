package org.usc.demo.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ShunLi
 */
public class T6 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

//        cal.add(Calendar.DATE, 1);
        System.out.println(cal.getTime());

        for(int i = 0 ; i< 100; i++){
            cal.add(Calendar.MONDAY, 1);
            System.out.println(cal.getTime());
        }

//        GregorianCalendar cal2 = new GregorianCalendar();
//        cal2.setTime(new Date());




    }
}
