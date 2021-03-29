package com.wb.pro.bean;

import com.wb.pro.bean.pattern.builder.BenzBuilder;
import com.wb.pro.bean.pattern.builder.BenzModel;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author wangbin
 * @date 2021/3/27 21:48
 */
public class CarModelTest {
    @Test
    public void carTest() {
        BenzModel benzModel = new BenzModel();
        ArrayList<String> sequece = new ArrayList<>();
        sequece.add("start");
        sequece.add("stop");
        benzModel.setSequence(sequece);
        benzModel.run();


        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequece);
        BenzModel benzModel1 = (BenzModel) benzBuilder.getCarModel();
        benzModel1.run();




    }
}
