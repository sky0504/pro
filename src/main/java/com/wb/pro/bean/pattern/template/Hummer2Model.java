package com.wb.pro.bean.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * 悍马2模型类
 *
 * @author wangbin
 * @date 2021/3/27 21:17
 */
@Slf4j
public class Hummer2Model extends HummerModel {
    @Override
    protected void start() {
        log.info("悍马2启动啦");
    }

    @Override
    protected void stop() {
        log.info("悍马2停止啦");
    }

    @Override
    protected void alarm() {
        log.info("悍马2鸣笛啦");
    }

    @Override
    protected void engineBoom() {
        log.info("悍马2引擎响起来啦");
    }
}
