package com.wb.pro.thread;

/**
 * 放弃当前CPU资源
 *
 * @author: WangBin
 * @create: 2020-01-29 21:20
 **/
public class YieIdThread extends Thread {
    private final int num = 5000000;

    @Override
    public void run() {
        super.run();
        long begin = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < num; i++) {
            //释放CPU资源---放弃的时间不确定，有可能刚刚放弃
            Thread.yield();
            count = count + (i + 1);
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "用时：" + (end - begin) + "毫秒");
    }
}
