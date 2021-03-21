package com.wb.pro.bean.pattern.singleton;

import com.wb.pro.util.LogPrintUtil;

/**
 * 皇帝--单例类
 * 练习单例模式
 *
 * @author wangbin
 * @date 2021/3/21 12:43
 */
public class Emperor {


    //这种方式称为饿汉式单例模式
    private static final Emperor EMPEROR = new Emperor();

    private Emperor() {

    }

    public static Emperor getInstance() {
        return EMPEROR;
    }

    public void say() {
        LogPrintUtil.systemOutPrintln("我就是皇帝某某某");
    }

}
