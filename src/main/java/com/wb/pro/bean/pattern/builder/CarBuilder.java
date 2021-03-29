package com.wb.pro.bean.pattern.builder;

import java.util.ArrayList;

/**
 * @author wangbin
 * @date 2021/3/27 21:50
 */
public abstract class CarBuilder {
    /**
     * 设置顺序
     *
     * @param sequence
     */
    public abstract void setSequence(ArrayList<String> sequence);

    /**
     * 获取车辆模型
     *
     * @return
     */
    public abstract CarModel getCarModel();
}
