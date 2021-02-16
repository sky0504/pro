package com.wb.pro.config;

import com.wb.pro.bean.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangbin
 * @date 2021/2/16 15:42
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandleConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        Response response = new Response();
        response.setStatus("400");
        response.setMessage("请求参数[" + e.getParameterName() + "]不能为空");
        return response;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        FieldError error = bindingResult.getFieldError();
//        bindingResult.getAllErrors()  所有错误信息
        StringBuilder sb = new StringBuilder();
        sb.append("参数").append(error.getField()).append(error.getDefaultMessage());
        String msg = sb.toString();
        return new Response<>("400", msg, null);
    }
}
