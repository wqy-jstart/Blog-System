package cn.tedu.blogsystem.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class UserArticleMapperTests {

    @Autowired
    private UserArticleMapper userArticleMapper;

    @Test
    public void selectToArticleId(){
        Long userId = 1L;
        List<Long> ids = userArticleMapper.selectToArticleId(userId);
        for (Long id : ids) {
            log.debug("文章id:{}",id);
        }
    }
}
