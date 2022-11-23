package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.dto.UserUpdateDTO;
import cn.tedu.blogsystem.pojo.entity.User;
import cn.tedu.blogsystem.pojo.vo.UserListItemVO;
import cn.tedu.blogsystem.pojo.vo.UserStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这是用户的数据访问层接口
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Repository
public interface UserMapper {

    /**
     * 执行插入用户的功能
     * @param user user实体类
     * @return 返回影响的行数
     */
    int insert(User user);

    /**
     * 注销操作出发删除用户信息的功能
     * @param id 要删除的用户id
     * @return 返回影响的条数
     */
    int deleteById(Long id);

    /**
     * 根据用户名查询数量
     * @param username 用户输入的用户名
     * @return 返回查询的数量
     */
    int countByUsername(String username);

    /**
     * 根据昵称查询数量
     * @param nickname 用户输入的昵称
     * @return 返回查询的数量
     */
    int countByNickname(String nickname);

    /**
     * 根据id修改用户数据
     * @param user 封装了新数据的对象
     * @return 受影响的行数
     */
    int update(User user);

    /**
     * 查询用户详情
     * @param id 要查询的用户id
     * @return 返回用户详情信息
     */
    UserStandardVO selectById(Long id);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户详情
     */
    UserStandardVO selectByUsername(String username);

    /**
     * 查询用户列表
     * @return 返回List集合
     */
    List<UserListItemVO> list();
}
