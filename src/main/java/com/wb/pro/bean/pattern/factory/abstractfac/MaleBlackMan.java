package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:55
 */
public class MaleBlackMan extends AbstractYellowHuman {
    @Override
    public void getSex() {
        LogPrintUtil.systemOutPrintln("黑种人男性");
    }
}
