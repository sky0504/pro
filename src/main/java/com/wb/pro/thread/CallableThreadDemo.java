package com.wb.pro.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @program: pro
 * @description:
 * @author: WangBin
 * @create: 2019-08-07 11:32
 **/
@Slf4j
public class CallableThreadDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            log.info("{}  {}", Thread.currentThread().getName(), i);
        }
        return i;
    }
}
