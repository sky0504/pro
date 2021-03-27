package com.wb.pro.bean.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * 悍马1模型类
 * @author wangbin
 * @date 2021/3/27 21:17
 */
@Slf4j
public class Hummer1Model extends HummerModel {
    @Override
    protected void start() {
        log.info("悍马1启动啦");
    }

    @Override
    protected void stop() {
        log.info("悍马1停止啦");
    }

    @Override
    protected void alarm() {
        log.info("悍马1鸣笛啦");
    }

    @Override
    protected void engineBoom() {
        log.info("悍马1引擎响起来啦");
    }

}
