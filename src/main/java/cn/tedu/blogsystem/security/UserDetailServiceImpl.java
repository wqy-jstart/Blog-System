package cn.tedu.blogsystem.security;

import cn.tedu.blogsystem.mapper.UserMapper;
import cn.tedu.blogsystem.pojo.vo.UserStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于Spring Security的登录认证创建的用户登录的(UserDetailsService接口)的实现类
 * 最终返回UserDetails,以便进行认证
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    // 重写loadUserByUsername(String s)"根据用户名加载用户的方法",Spring Security会自动传入用户名进行处理
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.debug("Spring Security框架自动调用UserDetailServiceImpl中的loadUserByUsername方法,参数{}", s);

        UserStandardVO user = userMapper.selectByUsername(s);
        log.debug("从数据库中根据用户名[{}]查询用户信息,结果{}",s,user);

        if (user==null){
            log.debug("没有与用户名[{}]匹配的用户信息,即将抛出BadCredentialsException",s);
            String message = "登录失败,用户名不存在!";
            throw new BadCredentialsException(message);// Spring Security提供的异常可抛给全局异常处理器
        }

        // 添加权限信息
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("这是一条假的权限信息");
        authorities.add(authority);

        // 使用新建的继承Spring Security的类AdminDetail来返回信息便于认证
        AdminDetails adminDetails = new AdminDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );

        log.debug("即将向Spring Security框架返回UserDetail对象:{}", adminDetails);
        return adminDetails; // 最终返回登录认证所需要的信息
    }
}

























