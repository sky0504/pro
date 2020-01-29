package com.wb.pro.thread;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 不共享变量测试类
 *
 * @author: WangBin
 * @create: 2020-01-29 14:04
 **/
@SpringBootTest
public class ShareNothingThreadTest {
    @Test
    public void testShareNothing() {
        ShareNothingThread thread1 = new ShareNothingThread("A");
        ShareNothingThread thread2 = new ShareNothingThread("B");
        ShareNothingThread thread3 = new ShareNothingThread("C");
        ShareNothingThread thread4 = new ShareNothingThread("D");
        ShareNothingThread thread5 = new ShareNothingThread("E");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
