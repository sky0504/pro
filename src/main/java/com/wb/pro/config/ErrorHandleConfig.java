package com.wb.pro.config;

import com.wb.pro.bean.Response;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangbin
 * @date 2021/2/16 15:42
 */
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
}
