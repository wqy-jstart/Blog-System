package cn.tedu.blogsystem.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Comment implements Serializable {
    /**
     * 评论id
     */
    private Long id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
