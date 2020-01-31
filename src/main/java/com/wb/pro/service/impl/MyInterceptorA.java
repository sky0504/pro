package com.wb.pro.service.impl;

import com.wb.pro.service.Interface.Interceptor;
import com.wb.pro.util.LogPrintUtil;

import java.lang.reflect.Method;

/**
 * 拦截器1
 *
 * @author: WangBin
 * @create: 2020-01-31 19:37
 **/
public class MyInterceptorA implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        LogPrintUtil.systemOutPrintln("【拦截器A】反射方法前逻辑");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        LogPrintUtil.systemOutPrintln("【拦截器A】取消了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        LogPrintUtil.systemOutPrintln("【拦截器A】反射方法后逻辑");
    }
}
