package com.wb.pro.bean.pattern.singleton;

/**
 * @author wangbin
 * @date 2021/3/21 12:47
 */
public class Minister {
    private static Minister MINISTER = null;

    public Minister() {

    }

    //此种处理方式称为懒汉式单例模式
    public static synchronized Minister getInstance() {
        if (MINISTER == null) {
            MINISTER = new Minister();
        }
        return MINISTER;
    }
}
