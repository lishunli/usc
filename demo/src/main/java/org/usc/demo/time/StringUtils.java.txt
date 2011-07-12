/*
 * StringUtils.java
 *
 * Created on Jan 26, 2010
 *
 * Copyright (c) 2010 Tai Fook Securities Group Limited.
 * All rights reserved.
 *
 * This file contains the valuable properties of Tai Fook Securities
 * Group Limited, embodying substantial creative efforts and confidential
 * information, ideas and expressions. No part of this file may be
 * reproduced or distributed in any form or by any means, or stored
 * in a data base or a retrieval system, without the prior written
 * permission of Tai Fook Securities Group Limited.
 */
package org.usc.demo.beanutils.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Leo Zhu
 *
 */
public class StringUtils {
    public static String dateToString(Date date, String pattern) {
        return DateTimeUtils.format(date, pattern);
    }

    public static String dateToString(Date date) {
        return DateTimeUtils.format(date);
    }

    public static Date stringToDate(String source, String pattern) throws ParseException {
        return DateTimeUtils.parse(source, pattern);
    }

    public static Date stringToDate(String source) throws ParseException {
        return DateTimeUtils.parse(source);
    }

    public static String getDefaultToDatePattern() {
        return DateTimeUtils.getSystemDateFormat();
    }

    public static Timestamp stringToTimestamp(String source) throws ParseException {
        return new Timestamp(DateTimeUtils.parse(source).getTime());
    }

    public static String timestampToString(Timestamp source) {
        return DateTimeUtils.format(source);
    }

}
