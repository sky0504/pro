package com.wb.pro.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 用于金额换算，从分换算成元
 * @author wangbin
 * @date 2021/2/18 11:29
 */
public class DoubleJsonSerializer extends JsonSerializer<Integer> {
    @Override
    public void serialize(Integer in, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        ObjectMapper om = new ObjectMapper();
        if (in != null) {
            Double temp = new BigDecimal(in.doubleValue()).divide(new BigDecimal(100)).doubleValue();
            DecimalFormat format = new DecimalFormat("##0.00");
            String reult = format.format(temp);
            om.writeValue(generator, reult);
        } else {
            om.writeValue(generator, "");
        }
    }
}
