package com.bjsxt.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {

	public static void main(String[] args) {
		
		Locale defaultLocale = Locale.getDefault();
		System.out.println("default country=" + defaultLocale.getCountry());
		System.out.println("default language=" + defaultLocale.getLanguage());
		
		//Locale currentLocale = new Locale("en", "US");
		//Locale currentLocale = new Locale("zh", "CN");
		
		Locale currentLocale = new Locale("ja", "JP");
		
		ResourceBundle rb = ResourceBundle.getBundle("res.MessagesBundle", currentLocale);
		//System.out.println(rb.getString("k1"));
		//System.out.println(rb.getString("k2"));
		
		MessageFormat mf = new MessageFormat(rb.getString("k1"));
		System.out.println(mf.format(new Object[]{"Tom"}));
		//System.out.println(mf.format(new Object[]{"ÕÅÈý"}));
	}
}
