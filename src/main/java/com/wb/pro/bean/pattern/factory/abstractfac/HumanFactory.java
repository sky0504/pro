package com.wb.pro.bean.pattern.factory.abstractfac;

import com.wb.pro.bean.pattern.factory.Human;

/**
 * @author wangbin
 * @date 2021/3/21 15:57
 */
public interface HumanFactory {
    /**
     * 创建一个黄种人
     *
     * @return
     */
    Human createYellowMan();

    /**
     * 创建一个白种人
     *
     * @return
     */
    Human createWhiteMan();

    /**
     * 创建一个黑人
     *
     * @return
     */
    Human createBlackMan();
}
