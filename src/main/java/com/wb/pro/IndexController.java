package com.wb.pro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: pro
 * @description:
 * @author: WangBin
 * @create: 2019-08-07 09:31
 **/
@RestController
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "Hello World!   ----   pro";
    }
}
