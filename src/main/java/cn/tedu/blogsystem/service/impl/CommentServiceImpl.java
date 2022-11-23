package cn.tedu.blogsystem.service.impl;

import cn.tedu.blogsystem.ex.ServiceException;
import cn.tedu.blogsystem.mapper.ArticleMapper;
import cn.tedu.blogsystem.mapper.CommentMapper;
import cn.tedu.blogsystem.mapper.UserArticleCommentMapper;
import cn.tedu.blogsystem.mapper.UserMapper;
import cn.tedu.blogsystem.pojo.dto.CommentAddNewDTO;
import cn.tedu.blogsystem.pojo.entity.Comment;
import cn.tedu.blogsystem.pojo.entity.User;
import cn.tedu.blogsystem.pojo.entity.UserArticleComment;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardVO;
import cn.tedu.blogsystem.pojo.vo.CommentListVO;
import cn.tedu.blogsystem.pojo.vo.UserStandardVO;
import cn.tedu.blogsystem.service.ICommentService;
import cn.tedu.blogsystem.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 评论的业务层接口实现类
 */
@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {

    public CommentServiceImpl(){
        log.debug("创建业务层实现类:CommentServiceImpl");
    }

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserArticleCommentMapper userArticleCommentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;


    /**
     * 处理向评论表和关联表插入数据的功能
     * @param commentAddNewDTO 评论信息
     */
    @Override
    public void insert(CommentAddNewDTO commentAddNewDTO) {
        log.debug("开始处理[添加评论]的业务!参数:{}",commentAddNewDTO);
        if (commentAddNewDTO.getContent()==null||commentAddNewDTO.getContent()==""){
            String message = "评论不能为空!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
        log.debug("即将向评论表插入信息...");
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentAddNewDTO,comment);
        LocalDateTime now = LocalDateTime.now();
        comment.setGmtCreate(now);
        log.debug("开始向评论表插入信息,参数:{}",comment);
        int rows = commentMapper.insert(comment);
        if (rows>1){
            String message = "插入失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }

        log.debug("即将向关联表插入信息...");
        UserStandardVO userStandard = userMapper.selectByUsername(commentAddNewDTO.getUsername());
        UserArticleComment userArticleComment = new UserArticleComment();
        userArticleComment.setUserId(userStandard.getId());
        userArticleComment.setArticleId(commentAddNewDTO.getArticleId());
        userArticleComment.setCommentId(comment.getId());
        userArticleComment.setGmtCreate(now);
        log.debug("开始向关联表插入信息,参数:{}",userArticleComment);
        rows = userArticleCommentMapper.insert(userArticleComment);
        if (rows>1){
            String message = "插入失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }

        log.debug("即将增加评论量!");
        UserStandardVO userStandardVO = userMapper.selectById(commentAddNewDTO.getUserId());
        Integer count = userStandardVO.getArticleCount();
        Integer NowCount = count+1;
        User user = new User();
        user.setId(commentAddNewDTO.getUserId());
        user.setArticleCount(NowCount);
        rows = userMapper.update(user);
        if (rows>1){
            String message = "修改失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
    }

    /**
     * 根据文章id加载文章的评论列表
     * @param articleId 文章id
     * @return 返回评论列表
     */
    @Override
    public List<CommentListVO> listByArticleId(Long articleId) {
        log.debug("开始处理[根据文章id加载评论列表]的业务!参数:{}",articleId);
        ArticleStandardVO articleStandardVO = articleMapper.selectById(articleId);
        if (articleStandardVO ==null){
            String message = "加载失败,文章id不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        log.debug("即将加载评论列表数据...");
        return commentMapper.listByArticleId(articleId);
    }
}
