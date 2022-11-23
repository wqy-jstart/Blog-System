package cn.tedu.blogsystem.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 这是文章的详情类
 */
@Data
public class ArticleStandardVO implements Serializable {
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
     * 文章排序
     */
    private Integer sort;

    /**
     * 文章图片
     */
    private String url;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
