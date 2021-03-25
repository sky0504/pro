package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.bean.pattern.factory.Human;

/**
 * 生产男性的八卦炉工厂
 * @author wangbin
 * @date 2021/3/21 15:59
 */
public class MaleHumanFactory implements HumanFactory {
    @Override
    public Human createYellowMan() {
        return new MaleYellowMan();
    }

    @Override
    public Human createWhiteMan() {
        return new MaleWhiteMan();
    }

    @Override
    public Human createBlackMan() {
        return new MaleBlackMan();
    }
}
