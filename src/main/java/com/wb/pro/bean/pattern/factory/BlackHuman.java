package com.wb.pro.bean.pattern.factory;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:14
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        LogPrintUtil.systemOutPrintln("黑人皮肤是黑色的");
    }

    @Override
    public void talk() {
        LogPrintUtil.systemOutPrintln("黑人会说啥啊");
    }
}
