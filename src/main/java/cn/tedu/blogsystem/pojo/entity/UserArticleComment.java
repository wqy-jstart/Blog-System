package cn.tedu.blogsystem.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserArticleComment implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 评论id
     */
    private Long commentId;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
