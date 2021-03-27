package com.wb.pro.bean;

import com.wb.pro.bean.pattern.factory.abstractfac.*;
import org.junit.Test;

/**
 * @author wangbin
 * @date 2021/3/27 21:08
 */
public class AbstractCreatorTest {
    @Test
    public void creatorTest() {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();

        AbstractProductA a1 = creator1.createProductA();
        AbstractProductA a2 = creator2.createProductA();

        AbstractProductB b1 = creator1.createProductB();
        AbstractProductB b2 = creator2.createProductB();
    }
}
