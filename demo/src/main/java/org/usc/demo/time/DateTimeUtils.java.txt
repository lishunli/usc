package org.usc.demo.beanutils.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

	public static final long DAY_IN_MILLIS = 24 * 60 * 60 * 1000;
	public static final long HOUR_IN_MILLIS = 60 * 60 * 1000;
	public static final long MINUTE_IN_MILLIS = 60 * 1000;

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMAT = "HH:mm:ss";

	private static DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
	private static DateFormat dateTimeFormatter = new SimpleDateFormat(DATE_TIME_FORMAT);
	private static DateFormat timeFormatter = new SimpleDateFormat(TIME_FORMAT);

	public static String format(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static String format(Date date, String format, Locale locale) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);
		return dateFormat.format(date);
	}

	public static String format(Date date) {
		return formatDate(date);
	}

	public static String formatDate(Date date) {
		synchronized (dateFormatter) {
			return dateFormatter.format(date);
		}
	}

	public static String formatDateTime(Date date) {
		synchronized (dateTimeFormatter) {
			return dateTimeFormatter.format(date);
		}
	}

	public static String formatTime(Date date) {
		synchronized (timeFormatter) {
			return timeFormatter.format(date);
		}
	}

	public static Date parse(String date) throws ParseException {
		return parseDate(date);
	}

	public static Date parseDate(String date, String format) throws ParseException {
		return parse(date, format);
	}

	public static Date parse(String date, String format) throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
	}

	public static Date parse(String date, String format, Locale locale) throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);
			return dateFormat.parse(date);
	}

	public static Date parseDate(String date) throws ParseException {
			synchronized (dateFormatter) {
				return dateFormatter.parse(date);
			}
	}

	public static Date parseDateTime(String date) throws ParseException {
			synchronized (dateTimeFormatter) {
				return dateTimeFormatter.parse(date);
			}
	}

	public static Date parseTime(String date) throws ParseException {
			synchronized (timeFormatter) {
				return timeFormatter.parse(date);
			}
	}

	public static String getSystemDateFormat() {
		return DATE_FORMAT;
	}

	public static String getSystemDateTimeFormat() {
		return DATE_TIME_FORMAT;
	}

	public static String getSystemTimeFormat() {
		return TIME_FORMAT;
	}

}
