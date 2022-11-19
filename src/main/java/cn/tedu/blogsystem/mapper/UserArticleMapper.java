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
     * 查询主页列表数据,无参
     * @return 返回list集合
     */
    List<UserArticleListItemVO> userAndArticleList();
}
