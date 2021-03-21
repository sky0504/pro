package com.wb.pro.bean.pattern.factory;

import com.wb.pro.util.LogPrintUtil;

/**
 * @author wangbin
 * @date 2021/3/21 15:17
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            LogPrintUtil.systemOutPrintln("创建人失败了" + e.getMessage());
        }
        return (T) human;
    }
}
