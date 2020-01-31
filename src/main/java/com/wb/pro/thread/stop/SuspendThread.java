package com.wb.pro.thread.stop;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: WangBin
 * @create: 2020-01-29 20:41
 **/
@Getter
@Setter
public class SuspendThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
        super.run();
        while (true) {
            i++;
        }
    }
}
