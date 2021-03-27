package com.wb.pro.bean.pattern.factory.abstractfac;

/**
 * @author wangbin
 * @date 2021/3/27 21:07
 */
public class Creator2 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
