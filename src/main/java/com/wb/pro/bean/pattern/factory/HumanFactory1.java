package com.wb.pro.bean.pattern.factory;

import com.wb.pro.util.LogPrintUtil;

/**
 * 简单工厂模式
 *
 * @author wangbin
 * @date 2021/3/21 15:30
 */
public class HumanFactory1 {
    public static <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            LogPrintUtil.systemOutPrintln("初始化人类工厂时失败");
        }
        return (T) human;
    }
}
