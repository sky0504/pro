package com.wb.pro.bean.pattern.factory.abstractfac;

/**
 * 抽象工程模式
 * @author wangbin
 * @date 2021/3/27 21:05
 */
public abstract class AbstractCreator {
    /**
     * 创建A产品家族
     *
     * @return
     */
    public abstract AbstractProductA createProductA();

    /**
     * 创建B产品家族
     *
     * @return
     */
    public abstract AbstractProductB createProductB();
}
