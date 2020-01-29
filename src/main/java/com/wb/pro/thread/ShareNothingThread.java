package com.wb.pro.thread;

/**
 * 不共享变量
 *
 * @author: WangBin
 * @create: 2020-01-29 14:02
 **/
public class ShareNothingThread extends Thread {

    private int count = 5;

    public ShareNothingThread(String name) {
        super();
        //设置线程的名称
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("线程名为:" + currentThread().getName() + ",计算count的结果为:" + count);
        }
    }
}
