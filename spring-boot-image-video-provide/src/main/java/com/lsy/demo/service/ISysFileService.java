package com.lsy.demo.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.model.SysFile;

/**
 *  服务类
 * @author lsy
 * @since 2020-05-03
 */
public interface ISysFileService extends IService<SysFile> {

       /**
        * 根据条件分页查询数据
        * @param pager
        * @return IPage
        */
        IPage<SysFile> pageSysFile(Pager<BaseParam<SysFile>> pager);
}
