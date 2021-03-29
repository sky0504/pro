package com.wb.pro.bean.pattern.builder;

import java.util.ArrayList;

/**
 * 建造者模式的使用类
 *
 * @author wangbin
 * @date 2021/3/27 21:56
 */
public class Director {

    private ArrayList<String> sequence = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BmwBuilder bmwBuilder = new BmwBuilder();

    public BenzModel getABenaModel1() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getABenaModel2() {
        this.sequence.clear();
        this.sequence.add("engine boom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BmwModel getABmwModel1() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(sequence);
        return (BmwModel) this.bmwBuilder.getCarModel();
    }

    public BmwModel getABmwModel2() {
        this.sequence.clear();
        this.sequence.add("engine boom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(sequence);
        return (BmwModel) this.bmwBuilder.getCarModel();
    }
}
