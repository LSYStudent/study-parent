package com.lsy.demo.commons.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *sql排序参数
 * @author lsy
 * @date 2020/4/30
 * @param <T>
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class BaseParam<T> extends TimeParam<T> {

    @ApiModelProperty(value = "排序字段")
    protected String orderBy;

    @ApiModelProperty(value = "正序：1 or 倒序：0")
    protected int asc;
}
