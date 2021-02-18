package com.wb.pro.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wangbin
 * @date 2021/2/18 22:48
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "找不到角色信息异常！")
public class RoleException extends RuntimeException {
    private static final long serialVersionUID = 124123423487662L;
}
