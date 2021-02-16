package com.wb.pro.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wangbin
 * @date 2021/2/16 15:44
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private String requestId;
    private String status;
    private String message;
    private T data;

    public Response() {
        requestId = String.valueOf(System.currentTimeMillis());
    }

    public Response(String status, String message, T data) {
        requestId = String.valueOf(System.currentTimeMillis());
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
