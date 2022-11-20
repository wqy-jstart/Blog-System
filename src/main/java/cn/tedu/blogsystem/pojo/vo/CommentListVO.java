package cn.tedu.blogsystem.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CommentListVO implements Serializable {

    /**
     * 评论id
     */
    private Long id;

    /**
     * 评论昵称
     */
    private String nickname;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
}
