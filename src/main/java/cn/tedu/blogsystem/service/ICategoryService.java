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
}
