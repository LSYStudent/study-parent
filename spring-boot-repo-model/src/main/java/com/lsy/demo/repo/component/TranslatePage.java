package com.lsy.demo.repo.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.commons.param.InParam;
import com.lsy.demo.commons.param.LikesParam;

/**
 * 分页条件对象
 * @author lsy
 * @date 2020/4/30
 */
public class TranslatePage {


    /**
     * 时间及排序查询
     * @param param
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> translateBaseParam(BaseParam<T> param) {
        if (null == param) {
            return new QueryWrapper<T>();
        }
        return new QueryWrapper<T>().ge(null != param.getStartTime(), StringUtils.camelToUnderline(param.getTimeName()), param.getStartTime()).le(null != param.getEndTime(), StringUtils.camelToUnderline(param.getTimeName()), param.getEndTime()).orderBy(null != param.getOrderBy(), param.getAsc() > 0, StringUtils.camelToUnderline(param.getOrderBy()));
    }


    /**
     * in查询
     * @param param
     * @param <V>
     * @param <T>
     * @return
     */
    public static <V, T> QueryWrapper<T> translateInParam(InParam<V, T> param) {
        QueryWrapper<T> queryWrapper = translateLikesParam(param);
        if (CollectionUtils.isEmpty(param.getInValue())) {
            return queryWrapper;
        }
        return queryWrapper.in(null != param.getInName(), StringUtils.camelToUnderline(param.getInName()), param.getInValue());
    }

    /**
     * like查询
     * @param param
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> translateLikesParam(LikesParam<T> param) {
        QueryWrapper<T> wrapper = translateBaseParam(param);
        if (CollectionUtils.isEmpty(param.getLikePairs())) {
            return wrapper;
        }
        wrapper.and(i -> {
            param.getLikePairs().stream().forEach(p -> {
                i.like(null != p.getKey(), StringUtils.camelToUnderline(p.getKey()), p.getValue());
            });
            return i;
        });
        return wrapper;
    }
}
