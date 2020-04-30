package com.lsy.demo.security.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.component.TranslatePage;
import com.lsy.demo.security.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.lsy.demo.repo.model.User;
import com.lsy.demo.repo.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


/**
 *  服务实现类
 * @author lsy
 * @since 2020-04-30
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements IUserService {

        /**
         * 根据条件查询数据列表
         * @param pager
         * @return
         */
        @Override
        public IPage<User> pageUser(Pager<BaseParam<User>> pager){
        return baseMapper.selectPage(Pager.translateParamPage(pager), TranslatePage.translateBaseParam(pager.getCondition()));
        }
}
