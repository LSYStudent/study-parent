package com.lsy.demo.repo.controller;

import com.lsy.demo.repo.service.IUserService;
import com.lsy.demo.repo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;



/**
 *  前端控制器
 * @author lsy
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private IUserService targetService;

    /**
    * 分页查询数据
    */
     @ApiOperation(value = "查询分页数据",notes = "查询分页数据", response = User.class)
     @PostMapping(value = "/page")
     public R<IPage<User>> pageUser(@RequestBody Pager<BaseParam<User>> pager){
         return R.ok(targetService.pageUser(pager), Constants.StatesType.SUCCESS.getCode());
     }

    /**
    * 查询全部数据
    */
    @ApiOperation(value = "查询全部数据",notes = "查询全部数据", response = User.class)
    @PostMapping(value = "/list")
    public R<List<User>> listUser(){
        return R.ok(targetService.list(), Constants.StatesType.SUCCESS.getCode());
    }


    /**
    * 新增数据
    * //TODO 注明所有业务场景
    */
    @ApiOperation(value = "新增数据",notes = "新增数据", response = Boolean.class)
    @PostMapping(value = "/save")
    public R<Boolean> save(@RequestBody User entity){
        return R.ok(targetService.save(entity.defv()), Constants.StatesType.SUCCESS.getCode());
    }

    /**
    * 更新数据
    * //TODO 注明所有业务场景
    */
    @ApiOperation(value = "更新数据",notes = "更新数据", response = Boolean.class)
    @PostMapping(value = "/update")
    public R<Boolean> update(@RequestBody User entity){
        return R.ok(targetService.updateById(entity), Constants.StatesType.SUCCESS.getCode());
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除数据",notes = "删除数据", response = Boolean.class)
    @PostMapping(value = "/del")
    public R<Boolean> delete(@RequestBody List<Long> ids){
        return R.ok(targetService.removeByIds(ids), Constants.StatesType.SUCCESS.getCode());
    }


}

