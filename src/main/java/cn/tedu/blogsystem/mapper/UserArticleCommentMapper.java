package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.entity.UserArticleComment;
import org.springframework.stereotype.Repository;

@Repository
public interface UserArticleCommentMapper {

    /**
     * 插入关联表信息
     * @param userArticleComment 插入的数据
     * @return 影响的行数
     */
    int insert(UserArticleComment userArticleComment);
}
