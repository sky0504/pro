package com.wb.pro.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: pro
 * @description:
 * @author: WangBin
 * @create: 2019-08-07 10:13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RunableDemoTest {

    @Test
    public void threadTest() {

        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();

        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();

    }
}
