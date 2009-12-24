package org.usc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataFormater
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String   myString   =   "Tue   Oct   18   04:11:56   CST   2005";  
		String testString ="Sun Sep 17 00:00:00 CST 2006";
		  try   {   
		  SimpleDateFormat   sdf   =   new   SimpleDateFormat("EEE   MMM   dd   HH:mm:ss   zzz   yyyy",   Locale.US);   
		  Date   d   =   sdf.parse(testString);   
		  Calendar   c   =   Calendar.getInstance();   
		  c.setTime(d);   
		  String   s   =   new   SimpleDateFormat("yyyy-MM-dd").format(c.getTime());   
		  System.out.println(s);   
		    
		  }   catch   (Exception   e)   {   
		  e.printStackTrace();   
		  }   
		  }

	}
