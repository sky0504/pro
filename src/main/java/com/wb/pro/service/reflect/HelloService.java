package com.wb.pro.service.reflect;

/**
 * 反射类
 *
 * @author: WangBin
 * @create: 2020-01-31 16:27
 **/
public class HelloService {

    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    public String retHello(String name) {
        String s = "Hello " + name;
        System.out.println(s);
        return s;
    }
}
