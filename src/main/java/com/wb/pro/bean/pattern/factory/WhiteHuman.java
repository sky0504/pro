package com.wb.pro.bean.pattern.factory;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:16
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        LogPrintUtil.systemOutPrintln("白人的皮肤是白色的");
    }

    @Override
    public void talk() {
        LogPrintUtil.systemOutPrintln("白人长得有些高大");
    }
}
