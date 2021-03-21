package com.wb.pro.bean.pattern.factory;

/**
 * 抽象人类创建工厂
 *
 * @author wangbin
 * @date 2021/3/21 15:13
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> c);
}
