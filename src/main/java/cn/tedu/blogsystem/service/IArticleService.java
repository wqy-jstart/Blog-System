package cn.tedu.blogsystem.service;

import cn.tedu.blogsystem.pojo.dto.ArticleAddNewDTO;
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

    ArticleStandardlVO articleDetail(Long id);

    /**
     * 查询主页的文章列表
     * @return 返回关联查询的结果
     */
    List<UserArticleListItemVO> userAndArticleList();
}
