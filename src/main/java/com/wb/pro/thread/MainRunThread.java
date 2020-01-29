package com.wb.pro.thread;

/**
 * mian方法和run方法执行时区别
 * @author: WangBin
 * @create: 2020-01-29 14:59
 **/
public class MainRunThread extends Thread {

    public MainRunThread() {
        System.out.println("构造方法的打印：" + Thread.currentThread().getName());
    }

    /**
     * run方法是自动调用的方法
     */
    @Override
    public void run() {
        super.run();
        System.out.println("run方法的打印：" + Thread.currentThread().getName());
    }
}
