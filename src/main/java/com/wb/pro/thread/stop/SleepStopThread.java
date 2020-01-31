package com.wb.pro.thread.stop;

/**
 * @author: WangBin
 * @create: 2020-01-29 19:51
 **/
public class SleepStopThread extends Thread {
    /**
     * 在sleep状态下停止线程，会抛出InterruptedException的异常，并且清除停止状态值，使之变为false
     * 反之，在停止状态下进行sleep也会抛出InterruptedException的异常
     */
    @Override
    public void run() {
        super.run();
        System.out.println("run begin" + System.currentTimeMillis());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("run sleep catch:" + this.isInterrupted() + "---" + System.currentTimeMillis() + "------" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("run end" + System.currentTimeMillis());
    }
}
