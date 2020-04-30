package com.lsy.demo.repo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * 
 * @author lsy
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User extends Model<User> {


/**
     * 赋予初值的构造方法
     */
public User defv(){
        setType(1);
        setStatus(1);
        setCreateTime(LocalDateTime.now());
        setUpdateTime(getCreateTime());
        return this;
        }

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
        @TableId(value = "id", type = IdType.AUTO)
        private Long id;

    @ApiModelProperty(value = "业务类型")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "逻辑删  0删除   1正常")
    @TableField("status")
    @TableLogic
    private Integer status;

    @ApiModelProperty(value = "业务状态")
    @TableField("result")
    private Integer result;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "银行卡号")
    @TableField("bank_card")
    private String bankCard;

    @ApiModelProperty(value = "生日")
    @TableField("birthday")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "用户头像")
    @TableField("avator_img")
    private String avatorImg;

    @ApiModelProperty(value = "个性签名")
    @TableField("user_signature")
    private String userSignature;

    @ApiModelProperty(value = "实名认证  0 否     1 是")
    @TableField("real_name_auth")
    private Integer realNameAuth;

    @ApiModelProperty(value = "用户注册ip")
    @TableField("reg_ip")
    private String regIp;

    @ApiModelProperty(value = "用户登录IP")
    @TableField("login_ip")
    private String loginIp;

    @ApiModelProperty(value = "登录时间")
    @TableField("login_time")
    private LocalDateTime loginTime;

    @ApiModelProperty(value = "下线时间")
    @TableField("out_time")
    private LocalDateTime outTime;


    @Override
    protected Serializable pkVal(){
            return this.id;
        }

}
