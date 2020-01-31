package com.wb.pro.handle.reflect;

import com.wb.pro.util.LogPrintUtil;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理例子
 *
 * @author: WangBin
 * @create: 2020-01-31 17:53
 **/
public class CglibProxyExampleHandle implements MethodInterceptor {
    /**
     * 生产CGLIB代理对象
     *
     * @param cls class类
     * @return 返回CGLIB代理对象
     */
    public Object getProxy(Class cls) {
        //增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象时间MethodInerceptor方法
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        LogPrintUtil.systemOutPrintln("调用真实对象前");
        Object obj = methodProxy.invokeSuper(o, objects);
        LogPrintUtil.systemOutPrintln("调用真实对象后");
        return obj;
    }
}
