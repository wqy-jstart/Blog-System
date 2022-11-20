package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class CategoryMapperTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void listByArticleId(){
        Long articleId = 13L;
        List<CategoryListItemVO> stringList = categoryMapper.listByArticleId(articleId);
        log.debug(stringList.toString());
    }
}
