package com.lsy.demo.security.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsy.demo.security.domain.UserDTO;

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

        /**
         * 发送邮件
         * @param dto
         * @return
         */
        String sendMail(UserDTO dto);
}
