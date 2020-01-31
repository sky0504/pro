package com.wb.pro.thread;

import com.wb.pro.vo.SynchronizedMethodVo;

/**
 * @author: WangBin
 * @create: 2020-01-30 12:15
 **/
public class SynchronizedMethodThread extends Thread {
    private SynchronizedMethodVo vo;

    public SynchronizedMethodThread(SynchronizedMethodVo vo) {
        this.vo = vo;
    }

    @Override
    public void run() {
        super.run();
        vo.method();
    }
}
