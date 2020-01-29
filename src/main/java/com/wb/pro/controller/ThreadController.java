package com.wb.pro.controller;

import com.wb.pro.thread.CallableThreadDemo;
import com.wb.pro.thread.RunnableDemo;
import com.wb.pro.thread.ThreadDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: pro
 * @description:
 * @author: WangBin
 * @create: 2019-08-07 10:12
 **/
@Slf4j
@RestController
@RequestMapping("/thread")
public class ThreadController {
    @GetMapping("/runnable")
    public String index() {
        RunnableDemo runnableDemo = new RunnableDemo("t-");
        runnableDemo.start();

        RunnableDemo runnableDemo1 = new RunnableDemo("thread-");
        runnableDemo1.start();

        return "thread Test";
    }

    @GetMapping
    public String thread() {
        ThreadDemo threadDemo = new ThreadDemo("t-");
        threadDemo.start();

        ThreadDemo threadDemo1 = new ThreadDemo("thread-");
        threadDemo1.start();
        return "thread Test";
    }

    @GetMapping("/callable")
    public String callable() throws ExecutionException, InterruptedException {
        CallableThreadDemo c = new CallableThreadDemo();
        FutureTask<Integer> ft = new FutureTask<>(c);
        for (int i = 0; i < 100; i++) {
            log.info("{} 的循环变量i的值{}", Thread.currentThread().getName(), i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        log.info("子线程的返回值{}", ft.get());
        return "thread Test";
    }
}
