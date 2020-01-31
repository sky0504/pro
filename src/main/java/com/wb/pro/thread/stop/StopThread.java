package com.wb.pro.thread.stop;

/**
 * @author: WangBin
 * @create: 2020-01-29 15:53
 **/
public class StopThread extends Thread {

    private final int count = 5000;

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < count; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
