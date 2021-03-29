package com.wb.pro.bean.pattern.builder;

import java.util.ArrayList;

/**
 * @author wangbin
 * @date 2021/3/27 21:51
 */
public class BmwBuilder extends CarBuilder {
    private BmwModel bmwModel = new BmwModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwModel;
    }
}
