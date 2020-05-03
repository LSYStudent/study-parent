package com.lsy.demo.security.domain;

import com.lsy.demo.repo.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户DTO类
 * @author lsy
 * @date 2020/5/4
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserDTO对象")
public class UserDTO extends User {

    @ApiModelProperty(value = "用户角色")
    private String role;
}
