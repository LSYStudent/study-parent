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
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_file")
@ApiModel(value = "SysFile对象", description = "")
public class SysFile extends Model<SysFile> {


/**
     * 赋予初值的构造方法
     */
public SysFile defv(){
        setType(1);
        setStatus(1);
        setResult(1);
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

    @ApiModelProperty(value = "逻辑删  0删除  1正常")
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

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "文件地址")
    @TableField("file_url")
    private String fileUrl;

    @ApiModelProperty(value = "目标ID")
    @TableField("target_id")
    private Long targetId;


    @Override
    protected Serializable pkVal(){
            return this.id;
        }

}
