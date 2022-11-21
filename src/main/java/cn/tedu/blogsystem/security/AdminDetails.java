package cn.tedu.blogsystem.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 这是继承了Spring Security框架中User的一个扩展详情类
 * 是Spring Security框架的loadUserByUsername()的返回结果
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Setter
@Getter
@ToString(callSuper = true)// 先把父类的toString()调用
@EqualsAndHashCode(callSuper = false)// 自动生成hashCode()方法和equals()方法
public class AdminDetails extends User {

    private Long id;

    public AdminDetails(Long id ,
                        String username,
                        String password,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true,
                true, authorities);
        this.id = id;
    }
}
