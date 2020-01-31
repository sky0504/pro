package com.wb.pro.vo;

/**
 * @author: WangBin
 * @create: 2020-01-29 20:59
 **/
public class SynchronizedSupendVo {
    synchronized public void printString() {
        System.out.println("SynchronizedSupendVo begin");

        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }

        System.out.println("SynchronizedSupendVo end");
    }
}
