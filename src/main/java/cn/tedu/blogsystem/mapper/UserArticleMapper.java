package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.entity.UserArticle;
import cn.tedu.blogsystem.pojo.vo.UserArticleListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserArticleMapper {

    /**
     * 插入关联数据
     * @param userArticle 用户文章数据
     * @return 影响的数量
     */
    int insert(UserArticle userArticle);

    /**
     * 根据用户id删除关联表中的数据
     * @param userId 用户id
     * @return 返回影响的条数
     */
    int deleteByUserId(Long userId);

    /**
     * 根据用户id查询文章id的列表项
     * @param userId 用户id
     * @return 返回文章id列表
     */
    List<Long> selectToArticleId(Long userId);

    /**
     * 查询主页列表数据,无参
     * @return 返回list集合
     */
    List<UserArticleListItemVO> userAndArticleList();
}
