package com.lsy.demo.repo.component;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.commons.param.InParam;
import com.lsy.demo.commons.param.LikesParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 分页参数
 * @author lsy
 * @date 2020/4/30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Pager<T> {

    @ApiModelProperty(value = "当前页")
    protected int current = 1;

    @ApiModelProperty(value = "页码")
    protected int page = 1;

    @ApiModelProperty(value = "页大小")
    protected int pageSize = 10;

    @ApiModelProperty(value = "参数 数据")
    protected T condition;

    @ApiModelProperty(value = "操作者ID")
    protected Long optId;

    //分页排序
    public static <T> Page<T> translateParamPage(Pager<BaseParam<T>> pager) {
        return new Page<T>(pager.getPage(), pager.getPageSize());
    }

    //分页in查询
    public static <V, T> Page<T> translateInParamPage(Pager<InParam<V,T>> pager) {
        return new Page<T>(pager.getPage(), pager.getPageSize());
    }

    //分页like查询
    public static <T> Page<T> tanslateLikeParamPage(Pager<LikesParam<T>> pager) {
        return new Page<>(pager.getPage(), pager.getPageSize());
    }
}
