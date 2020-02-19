package com.wb.pro.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据转换为Json相关
 *
 * @author: WangBin
 * @create: 2020-02-01 17:12
 **/
@Component
public class JsonUtil {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * object to json string
     *
     * @param obj
     * @return
     */
    public String writeValueAsString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LogPrintUtil.systemOutPrintln("JsonUtil convertObject catch " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
