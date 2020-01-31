package com.wb.pro.thread.stop;

import com.wb.pro.vo.SynchronizedObject;

/**
 *
 * @author: WangBin
 * @create: 2020-01-29 20:07
 **/
public class StopThrowLockThread extends Thread {
    private SynchronizedObject object;

    public StopThrowLockThread(SynchronizedObject object) {
        super();
        this.object = object;
    }

    /**
     * 使用stop释放锁将会造成不一致的结果，因此一定不要使用stop来停止线程
     */
    @Override
    public void run() {
        super.run();
        object.printString("b", "bb");
    }
}
