package com.wb.pro.service.Interface;

import java.lang.reflect.Method;

/**
 * 自定义拦截器接口
 *
 * @author: WangBin
 * @create: 2020-01-31 18:06
 **/
public interface Interceptor {
    /**
     * @param proxy  代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args   参数
     * @return
     */
    boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * @param proxy  代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args   参数
     * @return
     */
    void around(Object proxy, Object target, Method method, Object[] args);

    /**
     * @param proxy  代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args   参数
     * @return
     */
    void after(Object proxy, Object target, Method method, Object[] args);
}
