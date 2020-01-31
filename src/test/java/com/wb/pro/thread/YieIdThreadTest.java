package com.wb.pro.thread;

/**
 * @author: WangBin
 * @create: 2020-01-29 21:22
 **/
public class YieIdThreadTest {

    public static void main(String[] args) {
        YieIdThread yieIdThread = new YieIdThread();
        yieIdThread.setName("A");
        yieIdThread.start();
        yieIdThread.setPriority(1);
        YieIdThread yieIdThread1 = new YieIdThread();
        yieIdThread1.setName("B");
        yieIdThread1.start();
        yieIdThread1.setPriority(10);
    }
}
