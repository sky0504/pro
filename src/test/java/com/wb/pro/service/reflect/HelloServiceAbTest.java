package com.wb.pro.service.reflect;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: WangBin
 * @create: 2020-01-31 16:50
 **/
@SpringBootTest
public class HelloServiceAbTest {
    /**
     * 通过反射去创建实例对象，getConstructor的参数可以是多个
     */
    @Test
    public void say() {
        HelloServiceAb ab = null;

        try {
            ab = (HelloServiceAb) Class.forName("com.wb.pro.service.reflect.HelloServiceAb").getConstructor(String.class).newInstance("wb");
        } catch (InstantiationException e) {
            System.out.println("catct InstantiationException " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("catct IllegalAccessException " + e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("catct InvocationTargetException " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("catct NoSuchMethodException " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("catct ClassNotFoundException " + e.getMessage());
            e.printStackTrace();
        }
        ab.sayHello();
    }
}
