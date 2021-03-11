package com.yunchen.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final DateFormat FULL_DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat TIME_DF = new SimpleDateFormat("HH:mm:ss");

    public static String formatTimestamp(Object timestamp) {
        return FULL_DF.format(new Date(Long.parseLong(timestamp + "000")));
    }

    public static String formatDateTime(Date date) {
        return FULL_DF.format(date);
    }

    public static String formatDate(Date date) {
        return DATE_DF.format(date);
    }

    public static String formatTime(Date date) {
        return TIME_DF.format(date);
    }

    public static Date parseTime(String timeStr) throws ParseException {
        return TIME_DF.parse(timeStr);
    }

    public static Date parseDate(String dateStr) throws ParseException {
        return DATE_DF.parse(dateStr);
    }

    public static Date parseDateTime(String dateTimeStr) throws ParseException {
        return FULL_DF.parse(dateTimeStr);
    }

    public static Date mergeDateTime(String dateStr, String timeStr) throws ParseException {
        return parseDateTime(dateStr + " " + timeStr);
    }

    public static int getTimeStamp() {
        long timestamp = System.currentTimeMillis() / 1000;

        return (int) timestamp;
    }
}
