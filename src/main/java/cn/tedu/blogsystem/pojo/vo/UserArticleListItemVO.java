package cn.tedu.blogsystem.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 这是用户与文章结合的列表类
 */
@Data
public class UserArticleListItemVO implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 发布时间
     */
    private LocalDateTime gmtCreate;
}
