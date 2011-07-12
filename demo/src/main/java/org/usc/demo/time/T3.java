package org.usc.demo.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author ShunLi
 */
public class T3 {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-01");

		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(new Date());
		canlendar.add(Calendar.DATE, -1);

		Date lastMonthLastDay = canlendar.getTime();
		dateFormat.format(lastMonthLastDay);
		// Date lastMonthFirstDay =;

		// System.out.println(lastMonthFirstDay);
		System.out.println(lastMonthLastDay);

	}

}
