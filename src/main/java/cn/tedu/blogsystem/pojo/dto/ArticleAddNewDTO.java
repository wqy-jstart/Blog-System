package cn.tedu.blogsystem.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 发表文章的DTO类
 */
@Data
public class ArticleAddNewDTO implements Serializable {
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
     * 文章排序
     */
    private Integer sort;

    /**
     * 文章图片
     */
    private String url;

    /**
     * 发表时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 分类的id数组
     */
    private Long[] categoryIds;
}
