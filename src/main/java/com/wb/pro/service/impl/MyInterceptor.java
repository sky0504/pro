package com.wb.pro.service.impl;

import com.wb.pro.service.Interface.Interceptor;
import com.wb.pro.util.LogPrintUtil;

import java.lang.reflect.Method;

/**
 * 实现自定义拦截器的接口
 *
 * @author: WangBin
 * @create: 2020-01-31 18:08
 **/
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        LogPrintUtil.systemOutPrintln("反射方法前逻辑");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        LogPrintUtil.systemOutPrintln("取消了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        LogPrintUtil.systemOutPrintln("反射方法后逻辑");
    }
}
