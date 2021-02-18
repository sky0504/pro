package com.wb.pro.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Set;

/**
 * @author wangbin
 * @date 2021/2/18 16:15
 */
public class PinyinUtilTest {
    @Test
    public void string2CodeTest() throws JsonProcessingException {
        print("重曾长蔚");

        print("重曾111长ss蔚");

        print("111重曾长蔚");

        print("111重曾长蔚sss");

        print("重曾长蔚3344ww2");


        print("中国人民银行");

        print("曾行");
        print("");
        print(null);
        print("null");
    }

    private void print(String name) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Set<String> py = PinyinUtil.name2Code(name);
        LogPrintUtil.systemOutPrintln(String.valueOf(py.size()));
        LogPrintUtil.systemOutPrintln(objectMapper.writeValueAsString(py));
        LogPrintUtil.systemOutPrintln(String.join(",",py));
    }
}
