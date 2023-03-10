package cn.tedu.blogsystem.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册的DTO类
 */
@Data
public class UserRegisterDTO implements Serializable {

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
}
