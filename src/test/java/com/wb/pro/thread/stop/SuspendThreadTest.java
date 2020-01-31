package com.wb.pro.thread.stop;

/**
 * @author: WangBin
 * @create: 2020-01-29 20:42
 **/
public class SuspendThreadTest {
    /**
     * 线程的恢复和启用
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            SuspendThread suspendThread = new SuspendThread();
            suspendThread.start();
            suspendThread.sleep(5000);

            suspendThread.suspend();
            System.out.println("A=" + System.currentTimeMillis() + "--i=" + suspendThread.getI());
            Thread.sleep(5000);
            System.out.println("A=" + System.currentTimeMillis() + "--i=" + suspendThread.getI());

            suspendThread.resume();
            Thread.sleep(5000);


            suspendThread.suspend();
            System.out.println("B=" + System.currentTimeMillis() + "--i=" + suspendThread.getI());
            Thread.sleep(5000);
            System.out.println("B=" + System.currentTimeMillis() + "--i=" + suspendThread.getI());
        } catch (InterruptedException e) {
            System.out.println("main catch" + e.getMessage());
            e.printStackTrace();
        }

    }
}
