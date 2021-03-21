package com.wb.pro.bean;

import com.wb.pro.bean.pattern.singleton.Emperor;
import org.junit.Test;

/**
 * @author wangbin
 * @date 2021/3/21 14:32
 */
public class EmperorTest {
    @Test
    public void sayTest() {
        for (int i = 0; i < 3; i++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
