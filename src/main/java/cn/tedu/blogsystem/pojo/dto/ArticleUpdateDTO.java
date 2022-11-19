package cn.tedu.blogsystem.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 修改文章的实体类
 */
@Data
public class ArticleUpdateDTO implements Serializable {

    /**
     * 文章id
     */
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 文章内容
     */
    private String text;

    /**
     * 文章图片
     */
    private String url;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
