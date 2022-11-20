package cn.tedu.blogsystem.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CommentAddNewDTO implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 评论内容
     */
    private String content;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
}
