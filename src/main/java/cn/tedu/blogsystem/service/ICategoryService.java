package cn.tedu.blogsystem.service;

import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分类的业务层接口
 */
@Transactional
public interface ICategoryService {

    /**
     * 查询类别列表的业务层接口
     * @return 列表List
     */
    List<CategoryListItemVO> list();

    /**
     * 根据文章id查询类别名称
     * @param articleId 文章id
     * @return List字符串集合
     */
    List<CategoryListItemVO> listByArticleId(Long articleId);
}
