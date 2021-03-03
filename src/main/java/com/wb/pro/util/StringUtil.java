package com.wb.pro.util;

import java.text.NumberFormat;

/**
 * @author wangbin
 * @date 2020/11/8 4:30 下午
 */
public class StringUtil {
    public final static String STR = "";
    /**
     *  {@code " "}
     */
    public static final String SPACE = " ";
    /**
     * 点 {@code "."}
     */
    public static final String DOT = ".";
    /**
     * 斜杠 {@code "/"}
     */
    public static final String SLASH = "/";
    /**
     * 反斜杠 {@code "\\"}
     */
    public static final String BACKSLASH = "\\";
    /**
     * 回车符 {@code "\r"}
     */
    public static final String CR = "\r";
    /**
     * 换行符 {@code "\n"}
     */
    public static final String LF = "\n";
    /**
     * 减号（连接符） {@code "-"}
     */
    public static final String DASHED = "-";
    /**
     * 下划线 {@code "_"}
     */
    public static final String UNDERLINE = "_";
    /**
     * 逗号 {@code ","}
     */
    public static final String COMMA = ",";
    /**
     * 与 {@code "&"}
     */
    public static final String AMP = "&";
    /**
     * 冒号 {@code ":"}
     */
    public static final String COLON = ":";
    /**
     * 艾特 <code>"@"</code>
     */
    public static final String AT = "@";
    /**
     * 人民币 <code>"¥"</code>
     */
    public static final String RMB = "¥";

    /**
     * 是否有字符串
     * @param str 字符
     * @return 是否有字符串
     */
    public static Boolean hasText(CharSequence str) {
        return (str != null && str.length() > 0 && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否为空
     * @param obj
     * @return 是否为空
     */
    public static Boolean isEmpty(Object obj) {
        return (obj == null || "".equals(obj));
    }

    public static String removeBlankUpper(String str) {
        if (hasText(str)) {
            str = str.replace(SPACE, STR);
            str = str.toUpperCase();
        }
        return str;
    }

    /**
     * String trim
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        if (isEmpty(str)) {
            return str;
        } else {
            return str.trim();
        }
    }


    public static String str(CharSequence cs) {
        return null == cs ? null : cs.toString();
    }

    /**
     * 替换指定字符串的指定区间内字符为固定字符
     *
     * @param str          字符串
     * @param startInclude 开始位置（包含）
     * @param endExclude   结束位置（不包含）
     * @param replacedChar 被替换的字符
     * @return 替换后的字符串
     */
    public static String replace(CharSequence str, int startInclude, int endExclude, char replacedChar) {
        if (isEmpty(str)) {
            return str(str);
        }
        final int strLength = str.length();
        if (startInclude > strLength) {
            return str(str);
        }
        if (endExclude > strLength) {
            endExclude = strLength;
        }
        if (startInclude > endExclude) {
            // 如果起始位置大于结束位置，不替换
            return str(str);
        }

        final char[] chars = new char[strLength];
        for (int i = 0; i < strLength; i++) {
            if (i >= startInclude && i < endExclude) {
                chars[i] = replacedChar;
            } else {
                chars[i] = str.charAt(i);
            }
        }
        return new String(chars);
    }

    /**
     * 格式化百分比，小数采用四舍五入方式
     *
     * @param number 值
     * @param scale  保留小数位数
     * @return 百分比
     */
    public static String formatPercent(double number, int scale) {
        final NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(scale);
        format.setMaximumFractionDigits(scale);
        return format.format(number);
    }
}
