package cn.tedu.blogsystem.service;

import cn.tedu.blogsystem.pojo.dto.UserLoginDTO;
import cn.tedu.blogsystem.pojo.dto.UserRegisterDTO;
import cn.tedu.blogsystem.pojo.dto.UserUpdateDTO;
import cn.tedu.blogsystem.pojo.vo.UserStandardVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 这是用户的业务层接口类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IUserService {

    /**
     * 处理用户注册的功能
     * @param userRegisterDTO 注册时用户输入的信息
     */
    void addNew(UserRegisterDTO userRegisterDTO);

    /**
     * 处理用户登录的功能
     * @param userLoginDTO 用户登录传递的信息
     */
    void login(UserLoginDTO userLoginDTO);

    /**
     * 根据用户id修改用户信息
     * @param id 用户id
     * @param userUpdateDTO 修改的用户数据
     */
    void update(Long id,UserUpdateDTO userUpdateDTO);

    /**
     * 根据用户id修改用户密码
     * @param id 用户id
     * @param userUpdateDTO 修改的用户数据
     */
    void updateToPassword(Long id,UserUpdateDTO userUpdateDTO);

    /**
     * 根据用户名查询用户详情信息
     * @param username 用户名
     * @return 返回用户详情VO类
     */
    UserStandardVO userDetail(String username);

    /**
     * 根据id查询用户详情
     * @param id 用户id
     * @return 返回用户详情
     */
    UserStandardVO userStandard(Long id);
}