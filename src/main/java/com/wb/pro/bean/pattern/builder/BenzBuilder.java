package com.wb.pro.bean.pattern.builder;

import java.util.ArrayList;

/**
 * @author wangbin
 * @date 2021/3/27 21:51
 */
public class BenzBuilder extends CarBuilder {
    private BenzModel benzModel = new BenzModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
