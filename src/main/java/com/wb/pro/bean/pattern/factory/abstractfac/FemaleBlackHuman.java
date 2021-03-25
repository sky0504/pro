package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:54
 */
public class FemaleBlackHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        LogPrintUtil.systemOutPrintln("黑种人女性");
    }
}
