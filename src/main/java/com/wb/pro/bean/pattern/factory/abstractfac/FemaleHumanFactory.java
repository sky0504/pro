package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.bean.pattern.factory.Human;

/**
 * 生产女性的八卦炉工厂
 *
 * @author wangbin
 * @date 2021/3/21 15:58
 */
public class FemaleHumanFactory implements HumanFactory {
    @Override
    public Human createYellowMan() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteMan() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackMan() {
        return new FemaleBlackHuman();
    }
}
