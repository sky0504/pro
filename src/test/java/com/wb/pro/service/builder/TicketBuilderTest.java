package com.wb.pro.service.builder;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: WangBin
 * @create: 2020-01-31 20:40
 **/
@SpringBootTest
public class TicketBuilderTest {
    /**
     * 测试builder模式构建对象
     */
    @Test
    public void builderTest() {
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("成人票");
        helper.buildChildrenForSeat("有座儿童");
        helper.buildChildrenNoSeat("无座儿童");
        helper.buildElderly("老人票");
        helper.buildSoldier("军人票");
        TicketBuilder.builder(helper);
    }
}
