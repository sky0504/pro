package com.wb.pro.thread.safe;

import com.wb.pro.vo.MethodVariateSafe;

/**
 * @author: WangBin
 * @create: 2020-01-30 10:24
 **/
public class MethodVariateSafeThreadTest {

    public static void main(String[] args) {
        MethodVariateSafe safe = new MethodVariateSafe();
        MethodVariateSafeThread methodVariateSafeThread = new MethodVariateSafeThread(safe);
        methodVariateSafeThread.start();
        MethodVariateSafeAbThread methodVariateSafeAbThread = new MethodVariateSafeAbThread(safe);
        methodVariateSafeAbThread.start();
    }
}
