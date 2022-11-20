package cn.tedu.blogsystem.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 这是用户登录的DTO类
 */
@Data
public class UserLoginDTO implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录时是否勾选了记住用户名和密码
     */
    private Boolean rem;
}
