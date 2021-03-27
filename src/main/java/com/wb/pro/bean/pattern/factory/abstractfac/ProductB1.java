package com.wb.pro.bean.pattern.factory.abstractfac;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangbin
 * @date 2021/3/27 21:03
 */
@Slf4j
public class ProductB1 extends AbstractProductB {
    @Override
    public void doSomething() {
        log.info("产品B1的实现方法");
    }
}
