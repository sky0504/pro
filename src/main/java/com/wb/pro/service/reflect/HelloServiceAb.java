package com.wb.pro.service.reflect;

/**
 * @author: WangBin
 * @create: 2020-01-31 16:48
 **/
public class HelloServiceAb {
    private String name;

    public HelloServiceAb(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + name + "!");
    }
}
