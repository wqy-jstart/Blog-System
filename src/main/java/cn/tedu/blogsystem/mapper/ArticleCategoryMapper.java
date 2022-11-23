package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.entity.ArticleCategory;
import org.springframework.stereotype.Repository;

/**
 * 文章类别关联表的数据访问层接口
 */
@Repository
public interface ArticleCategoryMapper {

    /**
     * 向关联表中插入数据
     * @param articleCategory 要插入的数据类
     * @return 返回影响的行数
     */
    int insert(ArticleCategory articleCategory);

    /**
     * 根据用户id删除文章分类信息
     * @param userId 用户id
     * @return 受影响的行数
     */
    int deleteByUserId(Long userId);
}
