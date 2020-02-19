package com.wb.pro.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 性别枚举类
 *
 * @author: WangBin
 * @create: 2020-02-01 15:08
 **/
@Getter
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女");

    private int id;
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SexEnum getSexById(int id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }
}
