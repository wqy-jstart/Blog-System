package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章分类的数据访问层接口
 */
@Repository
public interface CategoryMapper {

    /**
     * 查询分类列表
     * @return 返回列表
     */
    List<CategoryListItemVO> list();
}
