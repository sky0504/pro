package com.wb.pro.thread;

/**
 * @author: WangBin
 * @create: 2020-01-29 14:32
 **/
public class SharePrintThread extends Thread {
    private int count = 5;

    /**
     * 此时还是有可能出现线程不安全的状况，因为执行println方法在内部是按照同步进行的，
     * 但是i--操作是在进入println之前发生的，所以还是有发生非线程安全问题的概率存在
     */
    @Override
    public void run() {
        super.run();
        System.out.println("由线程名为:" + currentThread().getName() + ",计算count的结果为:" + (count--));
    }
}
