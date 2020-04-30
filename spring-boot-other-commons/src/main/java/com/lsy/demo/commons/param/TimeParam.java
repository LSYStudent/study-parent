package com.lsy.demo.commons.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * sql时间参数
 * @author lsy
 * @date 2020/4/30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TimeParam<T> {

    @ApiModelProperty(value = "起始时间")
    protected LocalDateTime startTime;

    @ApiModelProperty(value = "结束时间")
    protected LocalDateTime endTime;

    @ApiModelProperty(value = "时间字段名称")
    protected String timeName;
}
