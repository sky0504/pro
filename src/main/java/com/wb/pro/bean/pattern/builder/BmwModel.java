package com.wb.pro.bean.pattern.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangbin
 * @date 2021/3/27 21:46
 */
@Slf4j
public class BmwModel extends CarModel {
    @Override
    protected void start() {
        log.info("宝马车开始启动了");
    }

    @Override
    protected void stop() {
        log.info("宝马车停止了");
    }

    @Override
    protected void alarm() {
        log.info("宝马车开始鸣笛了");
    }

    @Override
    protected void engineBoom() {
        log.info("宝马车开始轰鸣了");
    }
}
