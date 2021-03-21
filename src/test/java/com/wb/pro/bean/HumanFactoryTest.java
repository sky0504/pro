package com.wb.pro.bean;

import com.wb.pro.bean.pattern.factory.*;
import org.junit.Test;

/**
 * @author wangbin
 * @date 2021/3/21 15:20
 */
public class HumanFactoryTest {
    @Test
    public void createHumanTest() {
        AbstractHumanFactory yinyanglu = new HumanFactory();
        Human whiteMan = yinyanglu.createHuman(WhiteHuman.class);
        whiteMan.getColor();
        whiteMan.talk();

        Human blackMan = yinyanglu.createHuman(BlackHuman.class);
        blackMan.getColor();
        blackMan.talk();

        Human yellowMan = yinyanglu.createHuman(YellowHuman.class);
        yellowMan.getColor();
        yellowMan.talk();

    }

    @Test
    public void createHuman1Test() {
        Human whiteMan = HumanFactory1.createHuman(WhiteHuman.class);
        whiteMan.getColor();
        whiteMan.talk();

        Human blackMan = HumanFactory1.createHuman(BlackHuman.class);
        blackMan.getColor();
        blackMan.talk();

        Human yellowMan = HumanFactory1.createHuman(YellowHuman.class);
        yellowMan.getColor();
        yellowMan.talk();
    }
}
