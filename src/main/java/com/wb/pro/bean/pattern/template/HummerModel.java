package com.wb.pro.bean.pattern.template;

/**
 * 抽象悍马模型--模板方式模式
 *
 * @author wangbin
 * @date 2021/3/27 21:15
 */
public abstract class HummerModel {
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
    public void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    /**
     * 是否会响，，钩子方法
     *
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }
}
