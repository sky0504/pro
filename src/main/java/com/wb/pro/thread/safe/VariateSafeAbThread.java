package com.wb.pro.thread.safe;

import com.wb.pro.vo.VariateSafe;

/**
 * @author: WangBin
 * @create: 2020-01-30 10:36
 **/
public class VariateSafeAbThread extends Thread {
    private VariateSafe safe;

    public VariateSafeAbThread(VariateSafe safe) {
        this.safe = safe;
    }

    @Override
    public void run() {
        super.run();
        safe.addI("b");
    }
}
