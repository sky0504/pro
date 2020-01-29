package com.wb.pro.thread;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 共享变量测试类
 *
 * @author: WangBin
 * @create: 2020-01-29 13:58
 **/
@SpringBootTest
public class ShareThreadTest {
    @Test
    public void testShareThread() {
        ShareThread shareThread = new ShareThread();
        Thread a=new Thread(shareThread,"A");
        Thread b=new Thread(shareThread,"B");
        Thread c=new Thread(shareThread,"C");
        Thread d=new Thread(shareThread,"D");
        Thread e=new Thread(shareThread,"E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
