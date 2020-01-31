package com.wb.pro.thread;

import com.wb.pro.vo.SynchronizedMethodVo;

/**
 * @author: WangBin
 * @create: 2020-01-30 12:17
 **/
public class SynchronizedMethodThreadTest {
    /**
     * 两个线程同时进入方法内
     *
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedMethodVo vo = new SynchronizedMethodVo();
        SynchronizedMethodThread thread = new SynchronizedMethodThread(vo);
        SynchronizedMethodThreadAb threadAb = new SynchronizedMethodThreadAb(vo);
        thread.setName("A");
        threadAb.setName("AB");
        thread.start();
        threadAb.start();
    }
}
