package com.lsy.demo.repo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.lsy.demo.repo.model.User;
import com.lsy.demo.repo.mapper.UserMapper;
import com.lsy.demo.repo.service.IUserService;
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
        return baseMapper.selectPage(Pager.translateParamPage(pager), TranslatePage.translateParam(pager.getCondition()));
        }
}
