package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:55
 */
public class MaleYellowMan extends AbstractYellowHuman {
    @Override
    public void getSex() {
        LogPrintUtil.systemOutPrintln("黄种人男性");
    }
}
