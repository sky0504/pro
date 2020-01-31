package com.wb.pro.thread;

/**
 * 守护线程练习
 *
 * @author: WangBin
 * @create: 2020-01-30 08:50
 **/
public class DaemonThreadTest {

    public static void main(String[] args) {
        try {
            DaemonThread thread = new DaemonThread();
            //是否为线程的守护线程
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
