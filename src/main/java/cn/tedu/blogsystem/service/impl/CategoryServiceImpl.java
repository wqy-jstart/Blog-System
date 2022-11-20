package cn.tedu.blogsystem.service.impl;

import cn.tedu.blogsystem.ex.ServiceException;
import cn.tedu.blogsystem.mapper.ArticleMapper;
import cn.tedu.blogsystem.mapper.CategoryMapper;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardlVO;
import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import cn.tedu.blogsystem.service.ICategoryService;
import cn.tedu.blogsystem.web.ServiceCode;
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

    public CategoryServiceImpl(){
        log.debug("创建业务层实现类对象:CategoryServiceImpl");
    }

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 处理类别列表的业务
     * @return List
     */
    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理[查询类别列表]的业务");
        return categoryMapper.list();
    }

    /**
     * 根据文章id查询类别
     * @param articleId 文章id
     * @return 返回类别集合
     */
    @Override
    public List<CategoryListItemVO> listByArticleId(Long articleId) {
        log.debug("开始处理[根据文章id查询类别]的业务!");
        ArticleStandardlVO articleStandardlVO = articleMapper.selectById(articleId);
        if (articleStandardlVO==null){
            String message = "改文章不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        return categoryMapper.listByArticleId(articleId);
    }
}
