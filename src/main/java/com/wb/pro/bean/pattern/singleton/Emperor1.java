package com.wb.pro.bean.pattern.singleton;

import com.wb.pro.util.LogPrintUtil;

import java.util.ArrayList;
import java.util.Random;

/**
 * 有上限的单例模式
 *
 * @author wangbin
 * @date 2021/3/21 15:00
 */
public class Emperor1 {
    //最大创建数量
    private static int maxNumOfEmperor = 2;
    //姓名列表
    private static ArrayList<String> nameList = new ArrayList<>(2);
    //对象列表
    private static ArrayList<Emperor1> emperor1ArrayList = new ArrayList<Emperor1>(2);
    //当前数量
    private static int countNumOfEmperor = 0;

    public Emperor1() {
    }

    public Emperor1(String name) {
        nameList.add(name);
    }

    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperor1ArrayList.add(new Emperor1("皇" + i + "帝"));
        }
    }

    public static Emperor1 getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperor1ArrayList.get(countNumOfEmperor);
    }

    public void say() {
        LogPrintUtil.systemOutPrintln(nameList.get(countNumOfEmperor));
    }

}
