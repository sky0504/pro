package com.wb.pro.vo;

/**
 * @author: WangBin
 * @create: 2020-01-29 21:16
 **/
public class SynchronizedSupendTest {
    /**
     * 使用suspend方法来停止线程会造成数据不一致的问题
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final SynchronizedSupend synchronizedSupend = new SynchronizedSupend();
        Thread thread = new Thread() {
            public void run() {
                synchronizedSupend.setValue("a", "aa");
            }
        };
        thread.setName("a");
        thread.start();
        thread.sleep(500);
        Thread thread1 = new Thread() {
            public void run() {
                synchronizedSupend.printString();
            }
        };
        thread1.start();
    }
}
