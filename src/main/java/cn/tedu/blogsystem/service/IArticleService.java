package cn.tedu.blogsystem.service;

import cn.tedu.blogsystem.pojo.dto.ArticleAddNewDTO;
import cn.tedu.blogsystem.pojo.vo.ArticleListItemVO;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardlVO;
import cn.tedu.blogsystem.pojo.vo.UserArticleListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文章业务层接口类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Transactional
public interface IArticleService {

    /**
     * 处理发布文章的业务
     * @param articleAddNewDTO 需要发布的文章信息
     */
    void addNew(Long userId,ArticleAddNewDTO articleAddNewDTO);

    /**
     * 根据id查询文章详情
     * @param id id
     * @return 详情信息
     */
    ArticleStandardlVO articleDetail(Long id);

    /**
     * 查询主页的文章列表
     * @return 返回关联查询的结果
     */
    List<UserArticleListItemVO> userAndArticleList();

    /**
     * 根据id查询文章列表
     * @param id 用户id
     * @return 返回文章列表List集合
     */
    List<ArticleListItemVO> listById(Long id);
}
