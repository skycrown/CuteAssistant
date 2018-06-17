package net.skycrown.cuteassistant.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by skycrown on 2018/6/16.
 */

public class DateUtil {
    /**
     * 日期类型
     */
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String HHmmss = "HH:mm:ss";
    public static final String LOCALE_DATE_FORMAT = "yyyy年M月d日 HH:mm:ss";

    /**
     * 将Date类型转换成日期字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        String dateStr = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            dateStr = df.format(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateStr;
    }

    /**
     * 将日期字符转换成Date类型
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

}
