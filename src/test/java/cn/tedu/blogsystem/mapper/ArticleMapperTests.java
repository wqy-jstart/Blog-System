package cn.tedu.blogsystem.mapper;

import cn.tedu.blogsystem.ex.ServiceException;
import cn.tedu.blogsystem.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class ArticleMapperTests {
    // 将图片路径声明成不可变的量
    private final String dirPath = "C:\\Users\\admin\\IdeaProjects\\blog-client\\public\\";

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void deleteBatch(){
        List<Long> ids = new ArrayList<>();
        ids.add(10L);
        ids.add(11L);
        int i = articleMapper.deleteBatch(ids);
        log.debug("批量删除成功,删除数据的条数为:{}",i);
    }

    @Test
    public void selectBatchToUrl(){
        Long id = 4L;
        List<String> urls = articleMapper.selectBatchToUrl(id);
        for (String url : urls) {
            log.debug("开始删除图片:{}",url);
            if (!url.startsWith("http")) {// 如果不是以Http开头,说明不是网图,可进入循环执行本地删除操作,如果是网图,此次循环通过
                System.out.println("....");
            }
        }
    }
}
