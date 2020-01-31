package com.wb.pro.thread;

import com.wb.pro.vo.SynchronizedMethodVo;

/**
 * @author: WangBin
 * @create: 2020-01-30 12:16
 **/
public class SynchronizedMethodThreadAb extends Thread {
    private SynchronizedMethodVo vo;

    public SynchronizedMethodThreadAb(SynchronizedMethodVo vo) {
        this.vo = vo;
    }

    @Override
    public void run() {
        super.run();
        vo.method();
    }
}
