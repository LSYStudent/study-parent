package com.lsy.demo.security.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsy.demo.commons.exception.StudyBaseException;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.component.TranslatePage;
import com.lsy.demo.repo.mapper.UserMapper;
import com.lsy.demo.repo.model.User;
import com.lsy.demo.security.config.Constants;
import com.lsy.demo.security.domain.UserDTO;
import com.lsy.demo.security.mail.MailUtils;
import com.lsy.demo.security.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


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

        /**
         * 发送邮件
         * @param dto
         * @return
         */
        @Override
        public String sendMail(UserDTO dto) {
                User user = getOne(Wrappers.<User>query().lambda().eq(User::getEmail, dto.getEmail()));
                if (null != user) {
                        throw new StudyBaseException(Constants.LoginStatus.EMAIL_REGISTERED.getMsg(), Constants.LoginStatus.EMAIL_REGISTERED.getCode());
                }
                String code = MailUtils.generatorCode();
                MailUtils.sendMail(dto.getEmail(),code);
                return code;
        }
}
