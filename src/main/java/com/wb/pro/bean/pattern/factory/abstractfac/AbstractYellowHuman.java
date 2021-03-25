package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.bean.pattern.factory.Human;
import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:51
 */
public abstract class AbstractYellowHuman implements Human {

    @Override
    public void getColor() {
        LogPrintUtil.systemOutPrintln("黄种人的皮肤是黄色的");
    }

    @Override
    public void talk() {
        LogPrintUtil.systemOutPrintln("黄种人说话太搞笑了");
    }
}
