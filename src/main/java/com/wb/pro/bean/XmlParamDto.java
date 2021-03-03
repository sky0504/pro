package com.wb.pro.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * @author wangbin
 * @date 2021/3/3 10:10
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class XmlParamDto {

    @JacksonXmlProperty(isAttribute = true, localName = "name")   //name是project的attribute属性，不是value
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "class")   //name是project的attribute属性，不是value
    private String classStr;
    @JsonIgnore
    private String value;
}
