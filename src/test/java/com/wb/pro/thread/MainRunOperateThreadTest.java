package com.wb.pro.thread;

import org.junit.Test;

/**
 * @author: WangBin
 * @create: 2020-01-29 15:19
 **/
public class MainRunOperateThreadTest {
    @Test
    public void testMainRunOpera() {
        MainRunOperateThread mainRunOperateThread = new MainRunOperateThread();
        Thread t = new Thread(mainRunOperateThread);
        t.setName("A");
        t.start();
    }
}
