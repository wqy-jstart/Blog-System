package cn.tedu.blogsystem.service.impl;

import cn.tedu.blogsystem.mapper.CategoryMapper;
import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import cn.tedu.blogsystem.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类的业务层接口实现类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 处理类别列表的业务
     * @return List
     */
    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理[查询类别列表]的业务");
        return categoryMapper.list();
    }
}
