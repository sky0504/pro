package com.wb.pro.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author lyd
 * @date 2017/11/8
 * 反序列换的时候用于金额换算，从元换算成分
 */
@Slf4j
public class IntegerDeserializer extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) {
        try {
            BigDecimal bigAmount = new BigDecimal(p.getText()).multiply(new BigDecimal(100));
            //double 有精度问题
            //Double amount = Double.valueOf(p.getText()) * 100;
            return bigAmount.intValue();
        } catch (Exception e) {
            log.warn(e.getMessage());
            return null;
        }
    }
}
