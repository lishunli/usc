package org.usc.demo;
import org.apache.commons.lang.StringUtils;


/**
 *
 * @author ShunLi
 */
public class T4 {
    public static void main(String[] args) {
        String sample1 = "org.apache.catalina.startup.HostConfig deployDirectory";
        String sample2 = "org.apache";

        System.out.println(StringUtils.split(sample1, ".", 3));;
        System.out.println(StringUtils.split(sample2, ".", 3));;


/*        Calendar canlendar = Calendar.getInstance();
        canlendar.setTime(new Date());
        canlendar.add(Calendar.MONTH, -1);

        canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(canlendar.getTime());

        canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(canlendar.getTime());*/

/*        Calendar canlendar = Calendar.getInstance();
        canlendar.setTime(DateTimeUtils.parse("2011-03-12"));
        canlendar.add(Calendar.MONTH, -1);

        canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMinimum(Calendar.DAY_OF_MONTH));
        Date lastMonthFirstDay = canlendar.getTime();

        canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMaximum(Calendar.DAY_OF_MONTH));
        Date lastMonthLastDay = canlendar.getTime();

        System.out.println(lastMonthFirstDay);
        System.out.println(lastMonthLastDay);*/

//        Calendar canlendar = Calendar.getInstance();
//        canlendar.setTime(DateUtils.truncate(DateTimeUtils.parse("2011-03-12"), Calendar.MONTH));
//        canlendar.add(Calendar.DATE, -1);
//
//        Date lastMonthLastDay = canlendar.getTime();
//        Date lastMonthFirstDay = DateUtils.truncate(lastMonthLastDay, Calendar.MONTH);
//
//        System.out.println(lastMonthFirstDay);
//        System.out.println(lastMonthLastDay);

    }

}
