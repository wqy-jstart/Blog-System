package cn.tedu.blogsystem.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 类别列表VO类
 */
@Data
public class CategoryListItemVO implements Serializable {
    /**
     * 类别id
     */
    private Long id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别排序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;
}
