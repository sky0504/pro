package com.wb.pro.thread;

/**
 * 守护线程
 *
 * @author: WangBin
 * @create: 2020-01-30 08:48
 **/
public class DaemonThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("run catch " + e.getMessage());
            e.printStackTrace();
        }
    }
}
