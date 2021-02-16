package com.wb.pro.component;

import com.wb.pro.component.condition.IndexCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangbin
 * @date 2021/1/30 22:31
 */
@Slf4j
@Component
@Conditional(IndexCondition.class)
public class IndexComponent {

    @Scheduled(cron = "*/5 * * * * ?")
    public void index() {
        log.info("根据条件判断是否需要打印内容，，，现在需要打印");
    }

}
