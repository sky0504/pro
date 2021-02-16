package com.wb.pro.handle.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * 当创建结果集时，Mybatis会使用一个对象工程来完成创建这个结果集实例
 *
 * @author wangbin
 * @date 2021/1/30 20:31
 */
@Slf4j
public class MyObjectFactory extends DefaultObjectFactory {
    private Object temp = null;

    @Override
    public <T> T create(Class<T> type) {
        T t = super.create(type);
        log.info("创建对象：{}", t.toString());
        log.info("是否和上次创建的是同一个对象:【{}】", (temp == t));
        return t;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type, constructorArgTypes, constructorArgs);
        log.info("创建对象：{}", result.toString());
        temp = result;
        return result;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        log.info("初始化参数：【{}】", properties.toString());
    }
}
