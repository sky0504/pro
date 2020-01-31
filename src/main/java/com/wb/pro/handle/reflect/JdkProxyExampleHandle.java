package com.wb.pro.handle.reflect;

import com.wb.pro.util.LogPrintUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理例子
 *
 * @author: WangBin
 * @create: 2020-01-31 17:15
 **/
public class JdkProxyExampleHandle implements InvocationHandler {
    /**
     * 真实对象
     */
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        /**
         * 三个参数：
         * 1. 类加载器，采用了对象target本身的类加载器
         * 2. 把生成的动态代理对象下挂在哪些接口下，现在的写法就是在target实现的接口下。
         * 3. 定义实现方法逻辑的代理类，this表示当前对象，它必须实现InvocationHandler接口的invoke方法，它就是代理逻辑方法的现实方法
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理方法逻辑
     *
     * @param proxy  代理对象，，，bind方法生成的对象
     * @param method 当前调度方法
     * @param args   当前方法参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LogPrintUtil.systemOutPrintln("进入代理逻辑方法");
        LogPrintUtil.systemOutPrintln("进入代理逻辑方法");
        Object obj = method.invoke(target, args);
        if (obj != null) {
            LogPrintUtil.systemOutPrintln("代理返回的方法值为:" + obj.toString());
        }
        LogPrintUtil.systemOutPrintln("在调度真实对象之后的服务");
        return obj;

    }
}
