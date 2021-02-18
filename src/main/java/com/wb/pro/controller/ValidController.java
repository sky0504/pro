package com.wb.pro.controller;

import com.wb.pro.bean.ValidReq;
import com.wb.pro.config.RoleException;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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
    public Object validPost(@Valid @RequestBody ValidReq req, Model model) {
        req.setName(model.asMap().containsKey("projectName") ? model.asMap().get("projectName").toString() : "default");
        return req;
    }

    @GetMapping("/valid/error")
    public Object validPost(@RequestParam("id") String id) {
        if ("1".equals(id)) {
            throw new RoleException();
        }
        return null;
    }
}