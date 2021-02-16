package com.wb.pro.controller;

import com.wb.pro.bean.ValidReq;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangbin
 * @date 2021/2/16 15:37
 */
@RestController
public class ValidController {
    @GetMapping("/valid/index")
    public String validIndex(@RequestParam("id") String id, @RequestParam("name") String name) {
        return id;
    }

    @GetMapping("/valid/post")
    public String validPost(@Valid @RequestBody ValidReq req) {
        return req.toString();
    }
}
