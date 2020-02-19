package com.wb.pro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wb.pro.util.JsonUtil;
import com.wb.pro.util.LogPrintUtil;
import com.wb.pro.vo.IndexTestVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: WangBin
 * @create: 2020-02-01 11:27
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class IndexTestServiceTest {
    @Autowired
    IndexTestService service;
    @Autowired
    JsonUtil jsonUtil;
    @Test
    public void indexTest() throws JsonProcessingException {
        List<IndexTestVo> list = service.getIndexTestVoList();
        LogPrintUtil.systemOutPrintln(jsonUtil.writeValueAsString(list));
        List<IndexTestVo> list1 = service.getIndexTestVoList();
        LogPrintUtil.systemOutPrintln(jsonUtil.writeValueAsString(list1));
    }

    @Test
    public void getIndexTestVoListPageTest() throws JsonProcessingException {
        List<IndexTestVo> list = service.getIndexTestVoListPage(0, 2);
        LogPrintUtil.systemOutPrintln(jsonUtil.writeValueAsString(list));
    }
}
