package com.wb.pro.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: pro
 * @description: 通过实现Runnable接口的类创建一个线程
 * 为了实现 Runnable，一个类只需要执行一个方法调用 run()
 * @author: WangBin
 * @create: 2019-08-07 09:44
 **/
@Slf4j
public class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        log.info("Creating {}", threadName);
    }

    @Override
    public void run() {
        log.info("Running  {}", threadName);
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

    public void start() {
        log.info("Starting {},原线程名称{}", threadName, Thread.currentThread().getName());
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
