package cn.tedu.blogsystem.service.impl;

import cn.tedu.blogsystem.ex.ServiceException;
import cn.tedu.blogsystem.mapper.ArticleCategoryMapper;
import cn.tedu.blogsystem.mapper.ArticleMapper;
import cn.tedu.blogsystem.mapper.UserArticleMapper;
import cn.tedu.blogsystem.mapper.UserMapper;
import cn.tedu.blogsystem.pojo.dto.ArticleAddNewDTO;
import cn.tedu.blogsystem.pojo.entity.Article;
import cn.tedu.blogsystem.pojo.entity.ArticleCategory;
import cn.tedu.blogsystem.pojo.entity.UserArticle;
import cn.tedu.blogsystem.pojo.vo.ArticleListItemVO;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardlVO;
import cn.tedu.blogsystem.pojo.vo.UserArticleListItemVO;
import cn.tedu.blogsystem.service.IArticleService;
import cn.tedu.blogsystem.service.IUserService;
import cn.tedu.blogsystem.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 处理文章的业务层接口实现类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class ArticleServiceImpl implements IArticleService {

    public ArticleServiceImpl(){
        log.debug("创建业务层实现类对象:ArticleServiceImpl");
    }

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private UserArticleMapper userArticleMapper;


    /**
     * 向文章,类别关联表中插入数据
     * @param articleAddNewDTO 需要发布的文章信息
     */
    @Override
    public void addNew(Long id , ArticleAddNewDTO articleAddNewDTO) {
        log.debug("开始处理[发布文章]的业务,参数:{}",articleAddNewDTO);
        Article article = new Article();
        BeanUtils.copyProperties(articleAddNewDTO,article);
        LocalDateTime now = LocalDateTime.now();// 获取当前时间
        article.setGmtCreate(now); //设置发布时间
        log.debug("即将向数据库插入文章信息");
        int rows = articleMapper.insert(article);
        if (rows>1){
            String message = "发布失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }

        Long[] categoryIds = articleAddNewDTO.getCategoryIds();
        for (Long categoryId : categoryIds) {
            ArticleCategory articleCategory = new ArticleCategory();
            articleCategory.setUserId(id);
            articleCategory.setCategoryId(categoryId);
            articleCategory.setArticleId(article.getId());
            log.debug("即将向文章类别关联表中插入数据...");
            rows = articleCategoryMapper.insert(articleCategory);
            if (rows>1){
                String message = "发布失败,服务器忙,请稍后再试...";
                log.debug(message);
                throw new ServiceException(ServiceCode.ERR_INSERT,message);
            }
        }
        UserArticle userArticle = new UserArticle();
        userArticle.setUserId(id);
        userArticle.setArticleId(article.getId());
        log.debug("即将向用户文章关联表中插入数据...");
        rows = userArticleMapper.insert(userArticle);
        if (rows>1){
            String message = "发布失败,服务器忙,请稍后再试...";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
    }

    /**
     * 根据id查询文章详情
     * @param id 文章id
     * @return 文章详情类
     */
    @Override
    public ArticleStandardlVO articleDetail(Long id) {
        log.debug("开始处理[根据id查询文章详情]的业务,参数{}",id);
        ArticleStandardlVO articleStandardlVO = articleMapper.selectById(id);
        if (articleStandardlVO==null){
            String message = "该文章不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        return articleStandardlVO;
    }

    /**
     * 处理查询主页数据的业务
     * @return 返回List集合
     */
    @Override
    public List<UserArticleListItemVO> userAndArticleList() {
        log.debug("开始处理[查询主页列表信息]的业务,无参数");
        return userArticleMapper.userAndArticleList();
    }

    /**
     * 根据id查询文章列表
     * @param id 用户id
     * @return 返回列表
     */
    @Override
    public List<ArticleListItemVO> listById(Long id) {
        log.debug("开始处理[根据id查询文章列表]的业务,参数:{}",id);
        return articleMapper.listById(id);
    }
}
