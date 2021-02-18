package com.wb.pro.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wb.pro.config.RoleException;
import com.wb.pro.controller.ValidController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangbin
 * @date 2021/2/18 22:13
 */
@Slf4j
@RestControllerAdvice(basePackageClasses = ValidController.class)
public class ValidControllerAdvice {
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 是一个允许构建POJO参数的方法，允许在构造控制器参数的时候，加入一定的自定义规则
     *
     * @param dataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) throws JsonProcessingException {
        log.info("构造控制器参数之前的动作{}", objectMapper.writeValueAsString(dataBinder.getTarget()));
    }

    /**
     * 在进入控制器方法前运行。设置进去之后就可以在控制器方法中使用了
     * @param model
     */
    @ModelAttribute
    public void populateMode(Model model) {
        log.info("在进入控制器方法前运行");
        model.addAttribute("projectName", "wb");
    }

    @ExceptionHandler(Exception.class)
    public String exception() {
        log.info("在该控制器方法出现Exception错误的时候的处理");
        return "exception";
    }

    @ExceptionHandler(RoleException.class)
    public Object handleRoleException(RoleException e) {
        return "角色不存在异常";
    }

}
