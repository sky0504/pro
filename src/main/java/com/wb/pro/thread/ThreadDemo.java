package com.wb.pro.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: pro
 * @description: 创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例
 * @author: WangBin
 * @create: 2019-08-07 10:58
 **/
@Slf4j
public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    public ThreadDemo(String name) {
        threadName = name;
        log.info("Createing {}", threadName);
    }

    @Override
    public void run() {
        log.info("Runing {}", threadName);
        for (int i = 4; i > 0; i--) {
            log.info("Thread: {},{}", threadName, i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                log.error("Thread {} Interrupted", threadName);
            }
        }
        log.info("Thread {} exiting.", threadName);
    }

    @Override
    public void start() {
        log.info("Starting {},原线程名称{}", threadName, Thread.currentThread().getName());
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
