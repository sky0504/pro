package com.wb.pro.bean.pattern.builder;

import java.util.ArrayList;

/**
 * @author wangbin
 * @date 2021/3/27 21:40
 */
public abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList<>();

    /**
     * 要响喇叭
     */
    private boolean alarmFlag = true;

    /**
     * 启动
     */
    protected abstract void start();

    /**
     * 停止
     */
    protected abstract void stop();

    /**
     * 滴滴叫
     */
    protected abstract void alarm();

    /**
     * 引擎会轰隆隆地响
     */
    protected abstract void engineBoom();

    /**
     * 跑
     */
    final public void run() {
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            switch (actionName) {
                case "start":
                    this.start();
                    break;
                case "stop":
                    this.stop();
                    break;
                case "alarm":
                    if (this.isAlarm()) {
                        this.alarm();
                    }
                    break;
                case "engine boom":
                    this.engineBoom();
                    break;
                default:
                    break;
            }

        }

    }

    /**
     * 是否会响，，钩子方法
     *
     * @return
     */
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarmFlag(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
