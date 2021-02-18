package com.wb.pro.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author wangbin
 * @date 2021/2/18 16:15
 */
public class ExceptionUtils {

    public static String exceptionStackTraceAsString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.toString().replaceAll("\r", " ").replaceAll("\n", " ");
    }
}
