package com.wb.pro.service.reflect;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: WangBin
 * @create: 2020-01-31 16:30
 **/
@SpringBootTest
public class HelloServiceTest {
    @Test
    public void getRefObject() {
        HelloService helloService = null;
        try {
            helloService = (HelloService) Class.forName("com.wb.pro.service.reflect.HelloService").newInstance();
        } catch (InstantiationException e) {
            System.out.println("catch InstantiationException " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("catch IllegalAccessException " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("catch ClassNotFoundException " + e.getMessage());
            e.printStackTrace();
        }
        helloService.sayHello("wb");
    }

    @Test
    public void retHelloTest() {
        HelloService helloService = new HelloService();
        try {
            Method method = HelloService.class.getMethod("retHello", String.class);
            Object ret = method.invoke(helloService, "wb");
            System.out.println("get resule " + ret.toString());
        } catch (NoSuchMethodException e) {
            System.out.println("HelloServiceTest retHelloTest catch NoSuchMethodException " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("HelloServiceTest retHelloTest catch IllegalAccessException " + e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("HelloServiceTest retHelloTest catch InvocationTargetException " + e.getMessage());
            e.printStackTrace();
        }
    }
}
