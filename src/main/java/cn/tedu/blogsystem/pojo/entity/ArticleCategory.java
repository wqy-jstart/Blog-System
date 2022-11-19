package cn.tedu.blogsystem.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文章分类关联实体类
 *
 */
@Data
public class ArticleCategory implements Serializable {

    /**
     * 文章分类关联表id
     */
    private Long id;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 类别id
     */
    private Long categoryId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
