package com.wb.pro.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

/**
 * @author wangbin
 * @date 2021/3/3 10:05
 */
@Data
@JacksonXmlRootElement(localName = "jasperReport")
@JsonIgnoreProperties(ignoreUnknown = true)
public class XmlDto {
    /**
     * 所需要的参数信息列表
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "parameter")
    private List<XmlParamDto> parameter;

    /**
     * 所需要的参数信息列表
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "field")
    private List<XmlFiledDto> field;
}
