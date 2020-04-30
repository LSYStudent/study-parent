package com.lsy.demo.commons.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * sql模糊查询参数
 * @author lsy
 * @date 2020/4/30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class LikesParam<T> extends BaseParam<T> {

    List<LikePair> likePairs;

    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = false)
    public class LikePair {

        String key;

        String value;
    }
}
