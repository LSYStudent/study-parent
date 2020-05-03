package com.lsy.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lsy.demo.commons.component.R;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.model.SysFile;
import com.lsy.demo.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 *  前端控制器
 * @author lsy
 * @since 2020-05-03
 */
@RestController
@RequestMapping("/sys/file")
public class SysFileApi {

    @Autowired
    private ISysFileService targetService;

    /**
    * 分页查询数据
    */
     @ApiOperation(value = "查询分页数据",notes = "查询分页数据", response = SysFile.class)
     @PostMapping(value = "/page")
     public R<IPage<SysFile>> pageSysFile(@RequestBody Pager<BaseParam<SysFile>> pager){
         return R.ok(targetService.pageSysFile(pager));
     }

    /**
    * 查询全部数据
    */
    @ApiOperation(value = "查询全部数据",notes = "查询全部数据", response = SysFile.class)
    @PostMapping(value = "/list")
    public R<List<SysFile>> listSysFile(){
        return R.ok(targetService.list());
    }


    /**
    * 新增数据
    * //TODO 注明所有业务场景
    */
    @ApiOperation(value = "新增数据",notes = "新增数据", response = Boolean.class)
    @PostMapping(value = "/save")
    public R<Boolean> save(@RequestBody SysFile entity){
        return R.ok(targetService.save(entity.defv()));
    }

    /**
    * 更新数据
    * //TODO 注明所有业务场景
    */
    @ApiOperation(value = "更新数据",notes = "更新数据", response = Boolean.class)
    @PostMapping(value = "/update")
    public R<Boolean> update(@RequestBody SysFile entity){
        return R.ok(targetService.updateById(entity));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据",notes = "删除数据", response = Boolean.class)
    @PostMapping(value = "/del")
    public R<Boolean> delete(@RequestBody List<Long> ids){
        return R.ok(targetService.removeByIds(ids));
    }


}

