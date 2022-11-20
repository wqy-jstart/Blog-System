package cn.tedu.blogsystem.service;

import cn.tedu.blogsystem.pojo.dto.CommentAddNewDTO;
import cn.tedu.blogsystem.pojo.entity.Comment;
import cn.tedu.blogsystem.pojo.vo.CommentListVO;

import java.util.List;

/**
 * 评论业务层接口类
 */
public interface ICommentService {

    /**
     * 添加评论
     * @param commentAddNewDTO 评论信息
     */
    void insert(CommentAddNewDTO commentAddNewDTO);

    /**
     * 根据文章id查询评论列表
     * @param articleId 文章id
     * @return 评论列表
     */
    List<CommentListVO> listByArticleId(Long articleId);
}
