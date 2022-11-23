package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.dto.ArticleUpdateDTO;
import cn.tedu.blogsystem.pojo.entity.Article;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardlVO;
import cn.tedu.blogsystem.pojo.vo.ArticleListItemVO;
import cn.tedu.blogsystem.pojo.vo.UserArticleListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这是文章的数据访问层接口
 */
@Repository
public interface ArticleMapper {

    /**
     * 添加文章信息
     * @return 返回受影响的行数
     */
    int insert(Article article);

    /**
     * 删除文章信息
     * @param id 要删除的文章id
     * @return 返回受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据id批量删除文章id
     * @param ids id的List列表
     * @return 返回删除文章的条数
     */
    int deleteBatch(List<Long> ids);

    /**
     * 修改文章的信息
     * @param articleUpdateDTO 要修改的内容
     * @return 返回受影响的行数
     */
    int update(ArticleUpdateDTO articleUpdateDTO);

    /**
     * 根据用户id查询文章的数量
     * @param id 用户id
     * @return 返回指定用户的文章数量
     */
    int count(Long id);

    /**
     * 根据id查询文章详情
     * @param id 文章id
     * @return 返回指定文章的详情信息
     */
    ArticleStandardlVO selectById(Long id);

    /**
     * 根据标题查询文章详情
     * @param title 文章标题
     * @return 详情
     */
    ArticleStandardlVO selectByTitle(String title);

    /**
     * 查询指定用户的文章列表
     * @param userId 用户id
     * @return 返回文章列表
     */
    List<ArticleListItemVO> listById(Long userId);

    /**
     * 根据用户id关联查询文章图片路径
     * @param userId 用户id
     * @return 返回图片路径集合
     */
    List<String> selectBatchToUrl(Long userId);

    /**
     * 所有博客列表
     * @return 列表信息
     */
    List<UserArticleListItemVO> list();
}
