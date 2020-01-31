package com.wb.pro.thread.stop;

/**
 * @author: WangBin
 * @create: 2020-01-29 19:52
 **/
public class SleepStopThreadTest {
    public static void main(String[] args) {
        SleepStopThread sleepStopThread = new SleepStopThread();
        sleepStopThread.start();
        System.out.println("main start"+System.currentTimeMillis());
        try {
            sleepStopThread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("main sleep catch " + sleepStopThread.isInterrupted() + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("main sleep"+System.currentTimeMillis());
        sleepStopThread.interrupt();
        System.out.println("main end"+System.currentTimeMillis());
    }
}
