package com.taifook.mtss.mss.common.model;

import java.util.Locale;

/**
 * 
 * @author liwenqiu
 *
 */

public enum Language {
	
    ZH_TW(Locale.TRADITIONAL_CHINESE),
    ZH_CN(Locale.SIMPLIFIED_CHINESE),
    EN(Locale.ENGLISH);

    private Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    public static Language getLanguage(String locale) {
        for (Language s: Language.values()) {
            if (s.locale.toString().equals(locale)) {
                return s;
            }
        }
        return null;
    }
}
