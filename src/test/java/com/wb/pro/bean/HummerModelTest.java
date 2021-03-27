package com.wb.pro.bean;

import com.wb.pro.bean.pattern.template.Hummer1Model;
import com.wb.pro.bean.pattern.template.Hummer2Model;
import org.junit.Test;

/**
 * @author wangbin
 * @date 2021/3/27 21:21
 */
public class HummerModelTest {
    @Test
    public void hummerTest() {
        Hummer1Model h1 = new Hummer1Model();
        h1.run();

        Hummer2Model h2 = new Hummer2Model();
        h2.run();
    }
}
