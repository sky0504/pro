package com.wb.pro.thread.safe;

import com.wb.pro.vo.VariateSafe;

/**
 * 实例变量线程安全问题
 *
 * @author: WangBin
 * @create: 2020-01-30 10:46
 **/
public class VariateSafeThreadzTest {
    /**
     * 如果是实例变量，则可能存在非线程安全
     *
     * @param args
     */
    public static void main(String[] args) {
//        varuateTest();
        varuateTest1();
    }

    /**
     * 不同线程访问同一实例中的变量存在线程不安全的问题
     */
    private static void varuateTest() {
        VariateSafe safe = new VariateSafe();
        VariateSafeThread variateSafeThread = new VariateSafeThread(safe);
        variateSafeThread.start();
        VariateSafeAbThread variateSafeAbThread = new VariateSafeAbThread(safe);
        variateSafeAbThread.start();
    }

    /**
     * 不同线程访问不同实例的变量不存在非线程安全问题
     */
    private static void varuateTest1() {
        VariateSafe safe = new VariateSafe();
        VariateSafe safe1 = new VariateSafe();
        VariateSafeThread variateSafeThread = new VariateSafeThread(safe);
        variateSafeThread.start();
        VariateSafeAbThread variateSafeAbThread = new VariateSafeAbThread(safe1);
        variateSafeAbThread.start();
    }
}
