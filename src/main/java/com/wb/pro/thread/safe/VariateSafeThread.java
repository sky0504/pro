package com.wb.pro.thread.safe;

import com.wb.pro.vo.VariateSafe;

/**
 * @author: WangBin
 * @create: 2020-01-30 10:34
 **/
public class VariateSafeThread extends Thread {

    private VariateSafe safe;

    public VariateSafeThread(VariateSafe safe) {
        this.safe = safe;
    }

    @Override
    public void run() {
        super.run();
        safe.addI("a");
    }
}
