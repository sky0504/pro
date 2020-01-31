package com.wb.pro.thread.stop;

/**
 * @author: WangBin
 * @create: 2020-01-29 19:34
 **/
public class StopSleepThreadTest {

    public static void main(String[] args) {
        StopSleepThread stopSleepThread = new StopSleepThread();
        stopSleepThread.start();
        System.out.println("main start"+System.currentTimeMillis());
        stopSleepThread.interrupt();
        System.out.println("main end"+System.currentTimeMillis());
    }
}
