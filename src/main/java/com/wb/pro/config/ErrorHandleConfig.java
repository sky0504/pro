package com.wb.pro.config;

import com.wb.pro.bean.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.lang.reflect.Field;
import java.util.logging.FileHandler;

/**
 * @author wangbin
 * @date 2021/2/16 15:42
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandleConfig {
    /**
     * 缺失参数异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        Response response = new Response();
        response.setStatus("400");
        response.setMessage("请求参数[" + e.getParameterName() + "]不能为空");
        return response;
    }


    /**
     * 控制器方法参数无效异常，一般是参数方面的问题
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        FieldError error = bindingResult.getFieldError();
//        bindingResult.getAllErrors()  所有错误信息
        //找不到其他方法，暂时先去取对象中的某个字段的值吧
        Boolean t = null;
        try {
            Field field = e.getBindingResult().getTarget().getClass().getDeclaredField("t");
            field.setAccessible(true);
            try {
                t = (Boolean) field.get(e.getBindingResult().getTarget());
            } catch (IllegalAccessException illegalAccessException) {
                log.error("IllegalAccessException");
            }
        } catch (NoSuchFieldException noSuchFieldException) {
            log.error("NoSuchFieldException");
        }
        log.info("res {}", t);

        StringBuilder sb = new StringBuilder();
        sb.append("参数").append(error.getField()).append(error.getDefaultMessage());
        String msg = sb.toString();
        return new Response<>("400", msg, null);
    }

    /**
     * 数据绑定异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Object handleBindException(BindException e) {
        return null;
    }
    /**
     * 数据类型转换异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConversionNotSupportedException.class)
    public Object handleConversionNotSupportedException(ConversionNotSupportedException e) {
        return null;
    }

//    /**
//     * http媒体类型不可接受异常
//     * @param e
//     * @return
//     */
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
//        return null;
//    }
    /**
     * http媒体类型不支持异常
     * @param e
     * @return
     */
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleHttpMediaTypeNotSupportedExceptionUnsupported(HttpMediaTypeNotSupportedException e) {
        return null;
    }

    /**
     * http消息不可写异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public Object handleHttpMessageNotWritableException(HttpMessageNotWritableException e) {
        return null;
    }
    /**
     * http消息不可读异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return null;
    }

    /**
     * http请求找不到处理方法异常，往往是handlemapping找不到控制器或者其他方法响应
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return null;
    }

    /**
     * 方法中表明了采用multipart/form-data，而实际不是该请求
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public Object handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        return null;
    }

    /**
     * 设置一个POJO属性的时候，发现类型不对
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TypeMismatchException.class)
    public Object handleTypeMismatchException(TypeMismatchException e) {
        return null;
    }



}
