package com.wb.pro.handle.reflect;

import com.wb.pro.service.Interface.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 带有拦截器的动态代理
 *
 * @author: WangBin
 * @create: 2020-01-31 18:12
 **/
public class InterceptorJdkProxyHandle implements InvocationHandler {
    /**
     * 真实对象
     */
    private Object target = null;
    /**
     * 拦截器全限定名
     */
    private String interceptorClass = null;

    public InterceptorJdkProxyHandle(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象big返回一个【代理占位】
     *
     * @param target           真实对象
     * @param interceptorClass
     * @return
     */
    public static Object bind(Object target, String interceptorClass) {
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxyHandle(target, interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }
        Object result = null;
        //通过反射生产拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        //调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            //返回false
            interceptor.around(proxy, target, method, args);
        }
        //调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
