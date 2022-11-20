package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.entity.Comment;
import cn.tedu.blogsystem.pojo.vo.CommentListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    /**
     * 插入评论信息
     * @param comment 评论内容
     * @return 影响的行数
     */
    int insert(Comment comment);

    /**
     * 根据文章id查询评论列表
     * @return 返回List集合
     */
    List<CommentListVO> listByArticleId(Long articleId);
}
