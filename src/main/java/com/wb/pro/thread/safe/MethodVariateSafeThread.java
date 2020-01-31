package com.wb.pro.thread.safe;

import com.wb.pro.vo.MethodVariateSafe;

/**
 * 方法内变量安全
 *
 * @author: WangBin
 * @create: 2020-01-30 10:18
 **/
public class MethodVariateSafeThread extends Thread {
    private MethodVariateSafe safe;

    public MethodVariateSafeThread(MethodVariateSafe safe) {
        super();
        this.safe = safe;
    }

    @Override
    public void run() {
        super.run();
        safe.addI("a");
    }
}
