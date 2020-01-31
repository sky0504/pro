package com.wb.pro.vo;

/**
 * @author: WangBin
 * @create: 2020-01-30 12:01
 **/
public class SynchronizedMethodVo {

    public void method() {
        System.out.println("begin method threadName=" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("sleep catch" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
