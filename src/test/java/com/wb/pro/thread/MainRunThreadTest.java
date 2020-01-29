package com.wb.pro.thread;

/**
 * mian方法和run方法执行时区别
 * @author: WangBin
 * @create: 2020-01-29 15:00
 **/
public class MainRunThreadTest {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MainRunThread mainRunThread = new MainRunThread();
        mainRunThread.start();
//        mainRunThread.run();
    }
}
