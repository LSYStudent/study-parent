package com.lsy.demo.commons.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * sql in查询参数
 * @author lsy
 * @date 2020/4/30
 * @param <V>
 * @param <T>
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class InParam<V,T> extends LikesParam<T> {

    protected String inName;

    protected List<V> inValue;

}
