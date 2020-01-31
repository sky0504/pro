package com.wb.pro.service.impl;

import com.wb.pro.service.Interface.HelloInterface;
import com.wb.pro.util.LogPrintUtil;

/**
 * @author: WangBin
 * @create: 2020-01-31 17:44
 **/
public class HelloInterfaceImpl implements HelloInterface {
    @Override
    public void sayHello() {
        LogPrintUtil.systemOutPrintln("hello interface");
    }

    @Override
    public String getReturnStr(String name) {
        return "wb " + name;
    }
}
