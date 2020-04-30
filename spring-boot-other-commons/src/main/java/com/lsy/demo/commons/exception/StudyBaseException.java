package com.lsy.demo.commons.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常返回
 * @author lsy
 * @date 2020/4/29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudyBaseException extends RuntimeException{

    @ApiModelProperty(value = "异常等级")
    private int level;

    @ApiModelProperty(value = "异常消息")
    private String msg;

    @ApiModelProperty(value = "异常状态码")
    private int code;

    public StudyBaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public StudyBaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public StudyBaseException(int level, String msg, int code) {
        super(msg);
        this.level = level;
        this.msg = msg;
        this.code = code;
    }
}
