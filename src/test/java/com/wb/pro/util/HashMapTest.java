package com.wb.pro.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wb.pro.bean.ValidReq;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangbin
 * @date 2021/3/10 09:17
 */

public class HashMapTest {
    @Test
    public void getTest() {
        Map<Long, String> map = new HashMap<>();
        LogPrintUtil.systemOutPrintln("1L:" + map.get(1L));
        map.put(2L, "testetsete");
        LogPrintUtil.systemOutPrintln("1L:" + map.get(1L));
        LogPrintUtil.systemOutPrintln("2L:" + map.get(2L));
    }


    @Test
    public void getListMap() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ValidReq> list = new ArrayList<>();
        Map<Long, ValidReq> map = list.stream().collect(Collectors.toMap(ValidReq::getId, o -> o));
        LogPrintUtil.systemOutPrintln(objectMapper.writeValueAsString(map));
        LogPrintUtil.systemOutPrintln("1L:" + map.get(1L));
        ValidReq req = new ValidReq();
        req.setName("aa");
        req.setId(1L);
        req.setNum(33);
        list.add(req);
        ValidReq req1 = new ValidReq();
        req1.setName("aa1");
        req1.setNum(331);
        list.add(req1);
        map = list.stream().filter(data -> data.getId() != null).collect(Collectors.toMap(ValidReq::getId, o -> o));
        LogPrintUtil.systemOutPrintln(objectMapper.writeValueAsString(map));
        LogPrintUtil.systemOutPrintln("1L:" + map.get(1L));

//        map = list.stream().collect(Collectors.toMap(ValidReq::getId, o -> o));
//        LogPrintUtil.systemOutPrintln(objectMapper.writeValueAsString(map));
//        LogPrintUtil.systemOutPrintln("1L:" + map.get(1L));
    }

}
