package com.wb.pro.thread.stop;

import com.wb.pro.vo.SynchronizedObject;

/**
 * @author: WangBin
 * @create: 2020-01-29 20:22
 **/
public class StopThrowLockThreadTest {

    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        StopThrowLockThread stopThrowLockThread = new StopThrowLockThread(object);
        stopThrowLockThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("thread sleep catch:" + e.getMessage());
            e.printStackTrace();
        }
        stopThrowLockThread.stop();
        System.out.println(object.getUsername() + "   " + object.getPassword());
    }


}
