package com.wb.pro.service.Interface;

/**
 * 测试JDK动态代理
 *
 * @author: WangBin
 * @create: 2020-01-31 17:43
 **/
public interface HelloInterface {
    /**
     * 测试JDK动态代理
     */
    void sayHello();

    /**
     * 测试JDK动态代理获取返回值
     *
     * @param name
     * @return
     */
    String getReturnStr(String name);
}
