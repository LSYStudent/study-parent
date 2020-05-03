package com.lsy.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.component.TranslatePage;
import com.lsy.demo.service.ISysFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.lsy.demo.repo.model.SysFile;
import com.lsy.demo.repo.mapper.SysFileMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


/**
 *  服务实现类
 * @author lsy
 * @since 2020-05-03
 */
@Slf4j
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile>implements ISysFileService {

        /**
         * 根据条件查询数据列表
         * @param pager
         * @return
         */
        @Override
        public IPage<SysFile> pageSysFile(Pager<BaseParam<SysFile>> pager){
        return baseMapper.selectPage(Pager.translateParamPage(pager), TranslatePage.translateBaseParam(pager.getCondition()));
        }
}
