package com.wb.pro.controller;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wb.pro.bean.XmlDto;
import com.wb.pro.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author wangbin
 * @date 2021/3/3 10:04
 */
@Slf4j
@RestController
public class XmlController {

    @GetMapping("/xml")
    public Object xml() throws IOException {
        File file = new File("src/main/resources/static/jasperreports_template.jrxml");
        FileInputStream fileInputStream = new FileInputStream(file);
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(module);
        XmlDto xmlDto = mapper.readValue(fileInputStream, XmlDto.class);
        if (xmlDto != null && xmlDto.getParameter() != null && xmlDto.getParameter().size() > 0) {
            Map<String, Object> objectMap = new HashMap<>(xmlDto.getParameter().size());
            Random random = new Random();
            xmlDto.getParameter().stream().forEach(vo -> {
                switch (vo.getClassStr()) {
                    case "java.lang.String":
                        if (vo.getName().contains("image")||vo.getName().contains("img")) {
                            objectMap.put(vo.getName(), "https://www.best-seeing.com/public/img/logo.3f4d4a62.png");
                        } else {
                            objectMap.put(vo.getName(), getStr(random.nextInt(10)));
                        }
                        break;
                    case "java.lang.Long":
                        objectMap.put(vo.getName(), random.nextLong());
                        break;
                    case "java.lang.Boolean":
                        objectMap.put(vo.getName(), random.nextBoolean());
                        break;

                    case "java.lang.Double":
                        objectMap.put(vo.getName(), random.nextDouble());
                        break;
                    case "java.lang.Float":
                        objectMap.put(vo.getName(), random.nextFloat());
                        break;

                    case "java.lang.Integer":
                        objectMap.put(vo.getName(), random.nextInt());
                        break;
                    case "java.lang.Short":
                        objectMap.put(vo.getName(), random.nextInt(100));
                        break;

                    case "java.math.BigDecimal":
                        objectMap.put(vo.getName(), random.nextDouble());
                        break;

                    case "java.sql.Date":
                    case "java.util.Date":
                        objectMap.put(vo.getName(), new Date());
                        break;

                    case "java.sql.Time":
                        objectMap.put(vo.getName(), DateUtil.format(new Date(), DateUtil.TIME_PATTERN));
                        break;
                    case "java.sql.Timestamp":
                        objectMap.put(vo.getName(), DateUtil.getNow());
                        break;
                    default:
                        objectMap.put(vo.getName(), "未知类型");
                        break;
                }

            });
            return objectMap;
        }
        log.info("{}", xmlDto.toString());
        return null;
    }


    private String getStr(int num) {
        if (num < 1) {
            num = 1;
        }
        StringBuffer charValue = new StringBuffer();
        String str = "杭州贯通云科技有限公司";
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(10);
            charValue.append(str.charAt(number));
        }
        return charValue.toString();
    }


}
