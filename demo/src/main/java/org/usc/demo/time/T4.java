package org.usc.demo.time;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * 
 * @author ShunLi
 */
public class T4 {
	public static void main(String[] args) {

	}

	@Test
	public void test1() {
		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(new Date());
		canlendar.add(Calendar.MONTH, -1);

		canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMinimum(Calendar.DAY_OF_MONTH));
		System.out.println(canlendar.getTime());

		canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(canlendar.getTime());
	}

	@Test
	public void test2() {
		Calendar canlendar = Calendar.getInstance();

		DateTime dt = new DateTime(2011, 3, 18, 12, 25, 52, 0);
		canlendar.setTime(dt.toDate());
		canlendar.add(Calendar.MONTH, -1);

		canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMinimum(Calendar.DAY_OF_MONTH));
		Date lastMonthFirstDay = canlendar.getTime();

		canlendar.set(Calendar.DAY_OF_MONTH, canlendar.getMaximum(Calendar.DAY_OF_MONTH));
		Date lastMonthLastDay = canlendar.getTime();

		System.out.println(lastMonthFirstDay);
		System.out.println(lastMonthLastDay);
	}

	@Test
	public void test3() throws ParseException {
		Calendar canlendar = Calendar.getInstance();

		String[] parsePatterns = { "yyyy-MM-dd" };

		canlendar.setTime(DateUtils.truncate(DateUtils.parseDate("2011-03-12", parsePatterns), Calendar.MONTH));
		canlendar.add(Calendar.DATE, -1);

		Date lastMonthLastDay = canlendar.getTime();
		Date lastMonthFirstDay = DateUtils.truncate(lastMonthLastDay, Calendar.MONTH);

		System.out.println(lastMonthFirstDay);
		System.out.println(lastMonthLastDay);
	}

	@Test
	public void test4() {

	}

}
