package com.wb.pro.handle.reflect;

import com.wb.pro.service.reflect.HelloService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * CGLIB代理测试
 *
 * @author: WangBin
 * @create: 2020-01-31 18:01
 **/
@SpringBootTest
public class CglibProxyExampleHandleTest {
    @Test
    public void sayTest() {
        CglibProxyExampleHandle cglibProxyExampleHandle = new CglibProxyExampleHandle();
        HelloService helloService = (HelloService) cglibProxyExampleHandle.getProxy(HelloService.class);
        helloService.sayHello("haha");
    }
}
