package cn.irisicm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author hmhu6
 */
@Data
@TableName("ir_user")
@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @NotBlank(message="姓名不能为空")
    @Size(min = 2, max = 4, message = "name 姓名长度必须在 {min} - {max} 之间")
    private String username;

    /**
     * 用户密码，MD5加密
     */
    @ApiModelProperty(value = "用户密码，MD5加密")
    @NotBlank(message="密码不能为空")
    @Size(min = 5, max = 10, message = "name 密码长度必须在 {min} - {max} 之间")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 找回密码问题
     */
    @ApiModelProperty(value = "找回密码问题")
    private String question;

    /**
     * 找回密码答案
     */
    @ApiModelProperty(value = "找回密码答案")
    private String answer;

    /**
     * 角色0-管理员,1-普通用户
     */
    @ApiModelProperty(value = "角色0-管理员,1-普通用户")
    private Integer role;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 最后一次更新时间
     */
    @ApiModelProperty(value = "最后一次更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;

}
