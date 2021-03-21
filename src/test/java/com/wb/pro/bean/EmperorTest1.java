package com.wb.pro.bean;

import com.wb.pro.bean.pattern.singleton.Emperor1;
import org.junit.Test;

/**
 * @author wangbin
 * @date 2021/3/21 15:07
 */
public class EmperorTest1 {
    @Test
    public void sayTest() {
        for (int i = 0; i < 5; i++) {
            Emperor1 emperor1 = Emperor1.getInstance();
            emperor1.say();
        }
    }
}
