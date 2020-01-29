package com.wb.pro.thread;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: WangBin
 * @create: 2020-01-29 14:44
 **/
@SpringBootTest
public class SharePrintThreadTest {
    @Test
    public void testShare(){
        SharePrintThread shareThread=new SharePrintThread();
        Thread a=new Thread(shareThread);
        Thread b=new Thread(shareThread);
        Thread c=new Thread(shareThread);
        Thread d=new Thread(shareThread);
        Thread e=new Thread(shareThread);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
