package com.wb.pro.thread.stop;

/**
 * 线程终止的相关测试实验。
 *
 * @author: WangBin
 * @create: 2020-01-29 15:55
 **/
public class StopThreadTest {

    public static void main(String[] args) {
//        interrupt1();
//        interrupt2();
//        interrupt3();
        interrupt4();
    }

    /**
     * interrupt未中止线程
     */
    private static void interrupt1() {
        StopThread stopThread = new StopThread();
        stopThread.start();
        try {
            stopThread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("exception" + e.getMessage());
            e.printStackTrace();
        }
        stopThread.interrupt();
    }

    /**
     *
     */
    private static void interrupt2() {
        StopThread stopThread = new StopThread();
        stopThread.start();
        try {
            stopThread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("exception" + e.getMessage());
            e.printStackTrace();
        }
        stopThread.interrupt();

        System.out.println("是否停止1：" + stopThread.interrupted());

        System.out.println("是否停止2：" + stopThread.isInterrupted());
        System.out.println("      end!");
    }

    /**
     * interrupted会清除状态，因此两次获取的状态效果是不同的
     */
    private static void interrupt3() {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1：" + Thread.interrupted());

        System.out.println("是否停止2：" + Thread.interrupted());
        System.out.println("      end!");

    }

    /**
     * isInterrupted不会清除状态，因此两次结果是一致的
     */
    private static void interrupt4() {
        StopThread stopThread = new StopThread();
        stopThread.start();
        try {
            stopThread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("exception" + e.getMessage());
            e.printStackTrace();
        }
        stopThread.interrupt();

        System.out.println("是否停止1：" + stopThread.isInterrupted());

        System.out.println("是否停止2：" + stopThread.isInterrupted());
        System.out.println("      end!");
    }
}
