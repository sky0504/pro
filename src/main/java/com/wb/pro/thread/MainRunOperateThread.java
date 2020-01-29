package com.wb.pro.thread;

/**
 * 复杂情况下的main方法和run方法执行情况
 * @author: WangBin
 * @create: 2020-01-29 15:16
 **/
public class MainRunOperateThread extends Thread {
    public MainRunOperateThread (){
        System.out.println("MainRunOperateThread:  begin");
        System.out.println("Thread.currentThread().getName():  begin"+Thread.currentThread().getName());
        System.out.println("MainRunOperateThread:  this.getName()     "+this.getName());
        System.out.println("MainRunOperateThread:  end");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("MainRunOperateThread:  begin     run");
        System.out.println("Thread.currentThread().getName():  begin     run      "+Thread.currentThread().getName());
        System.out.println("MainRunOperateThread:  this.getName()     run     "+this.getName());
        System.out.println("MainRunOperateThread:  end     run");
    }
}
