package cn.tedu.blogsystem.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 这是用户的实体类,包含用户的所有信息
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//指定时间呈现格式和时区GMT+8东八区
    private Date birthday;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 个性签名
     */
    private String sign;
    /**
     * 文章数量
     */
    private Integer articleCount;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
