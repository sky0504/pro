package com.wb.pro.service.builder;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author: WangBin
 * @create: 2020-01-31 20:36
 **/
public class TicketHelper {

    public void buildAdult(String info){
        LogPrintUtil.systemOutPrintln("构建成年人票逻辑"+info);
    }
    public void buildChildrenForSeat(String info){
        LogPrintUtil.systemOutPrintln("构建有座儿童票逻辑"+info);
    }
    public void buildChildrenNoSeat(String info){
        LogPrintUtil.systemOutPrintln("构建无座儿童票逻辑"+info);
    }
    public void buildElderly(String info){
        LogPrintUtil.systemOutPrintln("构建老年人票逻辑"+info);
    }
    public void buildSoldier(String info){
        LogPrintUtil.systemOutPrintln("构建军人及其家属票逻辑"+info);
    }
}
