package com.lsy.demo.repo.service;

import com.lsy.demo.repo.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  服务类
 * @author lsy
 * @since 2020-04-30
 */
public interface IUserService extends IService<User> {

       /**
        * 根据条件分页查询数据
        * @param pager
        * @return IPage
        */
        IPage<User> pageUser(Pager<BaseParam<User>> pager);
}
