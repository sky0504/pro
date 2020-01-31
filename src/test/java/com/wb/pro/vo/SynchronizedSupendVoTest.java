package com.wb.pro.vo;

/**
 * @author: WangBin
 * @create: 2020-01-29 21:01
 **/
public class SynchronizedSupendVoTest {
    public static void main(String[] args) {
        try {
            final SynchronizedSupendVo vo = new SynchronizedSupendVo();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    vo.printString();
                }
            };
            thread.setName("a");
            thread.start();
            thread.sleep(1000);
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    super.run();
                    System.out.println("thread1启动了，但是进入不了printString。只打印一个begin");
                    System.out.println("因为printString方法被线程a锁定并暂停了");
                    vo.printString();
                }
            };
            thread1.start();
        } catch (InterruptedException e) {
            System.out.println("main catch sleep" + e.getMessage());
        }
        System.out.println("main end");
    }
}
