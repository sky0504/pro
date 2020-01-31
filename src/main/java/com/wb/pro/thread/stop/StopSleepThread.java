package com.wb.pro.thread.stop;

/**
 * 在沉睡中停止线程
 *
 * @author: WangBin
 * @create: 2020-01-29 19:31
 **/
public class StopSleepThread extends Thread {
    private final int count = 100000;

    /**
     * 在sleep状态下停止线程，会抛出InterruptedException的异常，并且清除停止状态值，使之变为false
     * 反之，在停止状态下进行sleep也会抛出InterruptedException的异常
     */
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < count; i++) {
            System.out.println("i=" + (i + 1));
        }

        System.out.println("run begin" + System.currentTimeMillis());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("run sleep catch(先停止，再遇到sleep):" + this.isInterrupted() + "---" + System.currentTimeMillis() + "------" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("run end" + System.currentTimeMillis());
    }
}
