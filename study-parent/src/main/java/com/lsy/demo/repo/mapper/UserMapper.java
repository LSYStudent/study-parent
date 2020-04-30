package com.lsy.demo.repo.mapper;

import org.apache.ibatis.annotations.Mapper;


import com.lsy.demo.repo.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 *  Mapper 接口
 * @author lsy
 * @since 2020-04-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
