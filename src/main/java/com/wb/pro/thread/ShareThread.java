package com.wb.pro.thread;

/**
 * 共享线程中的变量
 *
 * @author: WangBin
 * @create: 2020-01-29 13:54
 **/
public class ShareThread extends Thread {
    private int count = 5;

    /**
     * 如果要解决非线程安全问题，可在方法前面添加一个关键字 synchronized
     * 从而来保证此代码块儿的线程安全。
     */
    @Override
    public void run() {
        super.run();
        count--;
        /**
         * 在某些JVM中i--的操作步骤分为3步；
         * 1. 取得原有的i值
         * 2. 计算i-1
         * 3. 对i进行赋值
         * 在这三个步骤中如果有多个线程进行访问，那么一定会出现非线程安全问题
         */
        System.out.println("由线程名为:" + currentThread().getName() + ",计算count的结果为:" + count);
    }
}
