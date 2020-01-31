package com.wb.pro.handle.reflect;

import com.wb.pro.service.Interface.HelloInterface;
import com.wb.pro.service.impl.HelloInterfaceImpl;
import com.wb.pro.service.reflect.HelloService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 带有拦截器的动态代理
 *
 * @author: WangBin
 * @create: 2020-01-31 19:24
 **/
@SpringBootTest
public class InterceptorJdkProxyHandleTest {
    /**
     * 动态代理模式，单个拦截器
     */
    @Test
    public void interceptorJdkProxyTest() {
        HelloInterface helloService = (HelloInterface) InterceptorJdkProxyHandle.bind(new HelloInterfaceImpl(), "com.wb.pro.service.impl.MyInterceptor");
        helloService.sayHello();
    }

    /**
     * 测试责任链模式，，多个拦截器
     */
    @Test
    public void interceptorJdkProxyTest1() {
        HelloInterface helloServiceA = (HelloInterface) InterceptorJdkProxyHandle.bind(new HelloInterfaceImpl(), "com.wb.pro.service.impl.MyInterceptorA");
        HelloInterface helloServiceB = (HelloInterface) InterceptorJdkProxyHandle.bind(helloServiceA, "com.wb.pro.service.impl.MyInterceptorB");
        HelloInterface helloServiceC = (HelloInterface) InterceptorJdkProxyHandle.bind(helloServiceB, "com.wb.pro.service.impl.MyInterceptorC");
        helloServiceC.sayHello();
    }
}
