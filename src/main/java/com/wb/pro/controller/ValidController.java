package com.wb.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbin
 * @date 2021/2/16 15:37
 */
@RestController
public class ValidController {
    @GetMapping("/valid/index")
    public String validIndex(@RequestParam("id") String id,@RequestParam("name")String name) {
        return id;
    }
}
