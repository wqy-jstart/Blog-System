package cn.tedu.blogsystem.service.impl;

import cn.tedu.blogsystem.ex.ServiceException;
import cn.tedu.blogsystem.mapper.UserMapper;
import cn.tedu.blogsystem.pojo.dto.UserLoginDTO;
import cn.tedu.blogsystem.pojo.dto.UserRegisterDTO;
import cn.tedu.blogsystem.pojo.dto.UserUpdateDTO;
import cn.tedu.blogsystem.pojo.entity.User;
import cn.tedu.blogsystem.pojo.vo.UserStandardVO;
import cn.tedu.blogsystem.service.IUserService;
import cn.tedu.blogsystem.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 这是用户的业务层接口实现类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    public UserServiceImpl(){
        log.debug("创建业务层实现类对象:UserServiceImpl");
    }

    // 注入用户的DAO接口
    @Autowired
    private UserMapper userMapper;

    /**
     * 处理用户注册的业务
     *
     * @param userRegisterDTO 用户注册的DTO类
     */
    @Override
    public void addNew(UserRegisterDTO userRegisterDTO) {
        log.debug("开始处理[用户注册]的业务!参数{}", userRegisterDTO);
        log.debug("开始检查用户名是否被占用...");
        UserStandardVO userStandardVO = userMapper.selectByUsername(userRegisterDTO.getUsername());
        if (userStandardVO != null) {
            String message = "注册失败,该用户名已经被占用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        log.debug("开始检查昵称是否被占用...");
        int count = userMapper.countByNickname(userRegisterDTO.getNickname());
        if (count != 0) {
            String message = "注册失败,该昵称已经被占用!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        LocalDateTime now = LocalDateTime.now();
        user.setGmtCreate(now);
        user.setGmtModified(now);
        user.setArticleCount(0);
        user.setSign("这个人很懒,什么也没留下...");
        log.debug("即将向用户数据库中插入数据...");
        int rows = userMapper.insert(user);
        if (rows > 1) {
            String message = "注册失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
    }

    /**
     * 处理用户登录的业务
     *
     * @param userLoginDTO 用户登录传递的信息
     */
    @Override
    public void login(UserLoginDTO userLoginDTO) {
        log.debug("开始处理[用户登录]的业务!");
        log.debug("开始检查用户名是否存在...");
        UserStandardVO userStandardVO = userMapper.selectByUsername(userLoginDTO.getUsername());
        if (userStandardVO == null) {
            String message = "登录失败,该用户名不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND_LOGIN, message);
        }

        log.debug("开始检查密码是否错误...");
        if (!userLoginDTO.getPassword().equals(userStandardVO.getPassword())){
            String message = "登录失败,密码错误!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_PASSWORD,message);
        }
    }

    /**
     * 根据用户ID修改用户数据
     * @param id 用户id
     * @param userUpdateDTO 修改的用户数据
     */
    @Override
    public void update(Long id, UserUpdateDTO userUpdateDTO) {
        log.debug("开始处理[根据用户id修改用户信息的业务],id:{}",id);
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);
        user.setId(id);
        log.debug("即将修改用户信息!");
        log.debug("{}",user);
        int rows = userMapper.update(user);
        if (rows>1){
            String message = "修改失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }
    }

    /**
     * 执行修改密码的业务
     * @param id 用户id
     * @param userUpdateDTO 修改的用户数据
     */
    @Override
    public void updateToPassword(Long id, UserUpdateDTO userUpdateDTO) {
        log.debug("开始处理[根据用户id修改密码]的业务!,id:{},参数:{}",id,userUpdateDTO);
        UserStandardVO userStandardVO = userMapper.selectById(id);
        if (!userStandardVO.getUsername().equals(userUpdateDTO.getUsername())){
            String message = "修改失败,用户名不一致!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }
        if (userStandardVO.getPassword().equals(userUpdateDTO.getPassword())){
            String message = "修改失败,修改后的密码与原密码相同!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);
        user.setId(id);
        log.debug("即将进行修改密码...");
        int rows = userMapper.update(user);
        if (rows>1){
            String message = "修改失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE,message);
        }
    }

    /**
     * 开始处理根据用户名查询用户详情
     * @param username 用户名
     * @return 返回用户详情VO类
     */
    @Override
    public UserStandardVO userDetail(String username) {
        log.debug("开始处理[根据用户名查询用户详情]的业务!");
        return userMapper.selectByUsername(username);
    }

    /**
     * 根据用户id查询用户详情
     * @param id 用户id
     * @return 用户详情VO类
     */
    @Override
    public UserStandardVO userStandard(Long id) {
        log.debug("开始处理[根据id查询用户详情]的业务,参数:{}",id);
        UserStandardVO userStandardVO = userMapper.selectById(id);
        if (userStandardVO==null){
            String message = "该用户不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        return userStandardVO;
    }
}
