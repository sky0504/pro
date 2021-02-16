package com.wb.pro.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author wangbin
 * @date 2021/2/16 16:01
 */
@Data
public class ValidReq {
    private boolean t = true;

    @NotNull(message = "唯一ID不能为空")
    private Long id;

    @NotNull(message = "开始时间不能为空")
    //@Future 必须是将来的一个日期
    //@Past   必须是过去的日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Min(1)
    @Max(100)
    @NotNull(message = "大小不能为空")
    private Integer num;
}
