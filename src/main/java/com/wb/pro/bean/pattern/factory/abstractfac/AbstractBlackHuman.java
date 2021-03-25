package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.bean.pattern.factory.Human;
import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:51
 */
public abstract class AbstractBlackHuman implements Human {

    @Override
    public void getColor() {
        LogPrintUtil.systemOutPrintln("黑人皮肤是黑色的");
    }

    @Override
    public void talk() {
        LogPrintUtil.systemOutPrintln("黑人会说啥啊");
    }
}
