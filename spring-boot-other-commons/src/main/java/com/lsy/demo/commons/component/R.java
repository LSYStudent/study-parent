package com.lsy.demo.commons.component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 返回信息主体
 * @author lsy
 * @date 2020/4/29
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "响应信息主体")
public class R<T> {

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "异常信息")
    private String msg;

    @ApiModelProperty(value = "时间戳")
    private LocalDateTime timestamp;

    @ApiModelProperty(value = "数据")
    private T data;

    public static <T> R<T> ok(T data) {
         return restResult(200, null, LocalDateTime.now(), data);
    }

    public static <T> R<T> failed(int code, String msg) {
         return restResult(code, msg, LocalDateTime.now(), null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(0, msg, LocalDateTime.now(), null);
    }

    public static <T> R<T> restResult(int code, String msg, LocalDateTime timestamp, T data) {
        R<T> apiModel = new R<T>();
        apiModel.setCode(code);
        apiModel.setMsg(msg);
        apiModel.setTimestamp(timestamp);
        apiModel.setData(data);
        return apiModel;
    }
}
