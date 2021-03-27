package com.wb.pro.bean.pattern.factory.abstractfac;

/**
 * @author wangbin
 * @date 2021/3/27 21:01
 */
public abstract class AbstractProductA {
    /**
     * 每个产品共有的方法
     */
    public void shardMethod(){

    }

    /**
     * 每个产品相同方法，不同的实现
     */
    public abstract void doSomething();
}
