package com.wb.pro.bean.pattern.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 延迟加载的工厂类
 *
 * @author wangbin
 * @date 2021/3/21 15:41
 */
public class HumanLazyInitializationFactory {
    private static final Map<String, Human> HUMAN_MAP = new HashMap<>();

    //加入关键字synchronized保证线程安全
    public static synchronized Human createHuman(String type) {
        Human human = null;
        if (HUMAN_MAP.containsKey(type)) {
            return HUMAN_MAP.get(type);
        } else {
            if (type.equals("white")) {
                human = new WhiteHuman();
            } else {
                human = new YellowHuman();
            }
            HUMAN_MAP.put(type, human);
        }
        return human;
    }
}
