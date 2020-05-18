package com.lsy.demo.security.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lsy.demo.commons.component.R;
import com.lsy.demo.commons.param.BaseParam;
import com.lsy.demo.repo.component.Pager;
import com.lsy.demo.repo.model.User;
import com.lsy.demo.security.domain.UserDTO;
import com.lsy.demo.security.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
         return R.ok(targetService.pageUser(pager));
     }

    /**
     * 发送邮箱验证码
     * @param dto
     * @return
     */
    @ApiOperation(value = "发送邮箱验证码",notes = "发送邮箱验证码", response = User.class)
    @PostMapping(value = "/send/code")
    public R<String> sendMail(@RequestBody UserDTO dto){
        return R.ok(targetService.sendMail(dto));
    }

    /**
    * 查询全部数据
    */
    @ApiOperation(value = "查询全部数据",notes = "查询全部数据", response = User.class)
    @PostMapping(value = "/list")
    public R<List<User>> listUser(){
        return R.ok(targetService.list());
    }


    /**
    * 新增数据
    * //TODO 注明所有业务场景
    */
    @ApiOperation(value = "新增数据",notes = "新增数据", response = Boolean.class)
    @PostMapping(value = "/save")
    public R<Boolean> save(@RequestBody User entity){
        return R.ok(targetService.save(entity.defv()));
    }

    /**
    * 更新数据
    * //TODO 注明所有业务场景
    */
    @ApiOperation(value = "更新数据",notes = "更新数据", response = Boolean.class)
    @PostMapping(value = "/update")
    public R<Boolean> update(@RequestBody User entity){
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

