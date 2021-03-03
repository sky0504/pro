package com.wb.pro.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangbin
 * @date 2020/11/8 4:30 下午
 */
@Slf4j
public class DateUtil {
    public static final Long HOURS_ONE_DAY = 24L;
    public static final Long MINUTES_ONE_HOUR = 60L;
    public static final Long SECONDS_ONE_MINUTE = 60L;
    public static final Long MILLISECONDS_ONE_SECOND = 1000L;
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_ZH = "yyyy年M月d号";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String HOUR_MIN_PATTERN = "HHmm";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 锁对象
     */
    private static final Object lockObj = new Object();

    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    log.debug("put new sdf of pattern " + pattern + " to map");

                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = ThreadLocal.withInitial(() -> {
                        log.debug("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                        SimpleDateFormat df = new SimpleDateFormat(pattern);
                        df.setLenient(false);
                        return df;
                    });
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * 是用ThreadLocal<SimpleDateFormat>来获取SimpleDateFormat,这样每个线程只会有一个SimpleDateFormat
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static String format(Date date) {
        return getSdf(DATE_PATTERN).format(date);
    }

    public static String formatFromSecond(long second) {
        return formatFromSecond(second, DATE_PATTERN);
    }

    public static String formatFromSecond(long second, String pattern) {
        return formatFromMillis(second * MILLISECONDS_ONE_SECOND, pattern);
    }

    public static String formatFromMillis(long millis, String pattern) {
        return getSdf(pattern).format(new Date(millis));
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

    public static Long getNow() {
        return System.currentTimeMillis() / MILLISECONDS_ONE_SECOND;
    }

    public static Long getNowMillis() {
        return System.currentTimeMillis();
    }

    //region 指定日期的开始时间和结束时间

    public static Long getDayBeginTime(String in) throws ParseException {
        if (StringUtil.isEmpty(in)) {
            return null;
        }
        return parse(in, DATE_PATTERN).getTime() / MILLISECONDS_ONE_SECOND;
    }

    public static Long getDayBeginTimeMills(String in) throws ParseException {
        if (StringUtil.isEmpty(in)) {
            return null;
        }
        return parse(in, DATE_PATTERN).getTime();
    }

    public static Long getDayBeginTime(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return getDayBeginTimeMills(date) / MILLISECONDS_ONE_SECOND;
    }

    public static Long getDayBeginTimeMills(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime().getTime();
    }

    public static Long getDayEndTime(String in) throws ParseException {
        if (StringUtil.isEmpty(in)) {
            return null;
        }
        Date date = parse(in, DATE_PATTERN);
        return getDayEndTime(date);
    }

    public static Long getDayEndTimeMills(String in) throws ParseException {
        if (StringUtil.isEmpty(in)) {
            return null;
        }
        Date date = parse(in, DATE_PATTERN);
        return getDayEndTimeMills(date);
    }

    public static Long getDayEndTime(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return getDayEndTimeMills(date) / MILLISECONDS_ONE_SECOND;
    }

    public static Long getDayEndTimeMills(Date date) {
        Long endTime = null;
        if (!StringUtil.isEmpty(date)) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            c.set(Calendar.MILLISECOND, 999);
            endTime = c.getTime().getTime();
        }
        return endTime;
    }

    //endregion
}
