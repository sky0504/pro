package com.wb.pro.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author wangbin
 * @date 2021/2/18 16:13
 */
public class PinyinUtil {

    public static String string2Code(String chinese) {
        if (StringUtils.isEmpty(chinese)) {
            return null;
        }
        StringBuilder pybf = new StringBuilder();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char anArr : arr) {
            if (anArr > 128) {
                try {
                    String[] tArray = PinyinHelper.toHanyuPinyinStringArray(anArr, defaultFormat);
                    if (tArray != null && tArray.length > 0) {
                        pybf.append(tArray[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    LogPrintUtil.systemOutPrintln(ExceptionUtils.exceptionStackTraceAsString(e));
                }
            } else {
                pybf.append(anArr);

            }
        }
        return pybf.toString();
    }

    public static Set<String> name2Code(String chinese) {
        if (StringUtils.isEmpty(chinese)) {
            return Collections.emptySet();
        }
        StringBuilder pybf = new StringBuilder();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        List<char[]> chars = new ArrayList<>(arr.length);
        List<StringBuilder> list = new ArrayList<>();
        for (char anArr : arr) {
            if (anArr > 128) {
                try {
                    String[] tArray = PinyinHelper.toHanyuPinyinStringArray(anArr, defaultFormat);
                    if (tArray != null && tArray.length > 0) {
                        pybf.append(tArray[0].charAt(0));
                        char[] arrTmp = new char[tArray.length];
                        for (int i = 0; i < tArray.length; i++) {
                            arrTmp[i] = tArray[i].charAt(0);
                        }
                        chars.add(arrTmp);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    LogPrintUtil.systemOutPrintln(ExceptionUtils.exceptionStackTraceAsString(e));
                }
            } else {
                pybf.append(anArr);
                chars.add(new char[]{anArr});
            }
        }
        if (chars.size() == 0) {
            return Collections.emptySet();
        }
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < chars.size(); i++) {
            List<StringBuilder> tmpList = new ArrayList<>();
            //是否是最后一次循环
            boolean t = (i == chars.size() - 1);
            for (int j = 0; j < chars.get(i).length; j++) {
                if (i == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(chars.get(i)[j]);
                    if (t) {
                        strings.add(sb.toString());
                    } else {
                        tmpList.add(sb);
                    }
                } else {
                    for (StringBuilder bs : list) {
                        StringBuilder sbTmp = new StringBuilder();
                        sbTmp.append(bs.toString()).append(chars.get(i)[j]);
                        if (t) {
                            strings.add(sbTmp.toString());
                        } else {
                            tmpList.add(sbTmp);
                        }
                    }
                }
            }
            list.clear();
            list.addAll(tmpList);
        }
        return strings;
    }
}
