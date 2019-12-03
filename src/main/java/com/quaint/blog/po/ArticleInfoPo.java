package com.quaint.blog.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-28 10:06
 */
@Data
@TableName("article_info")
public class ArticleInfoPo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // '文章标题'
    @TableField("article_title")
    private String articleTitle;

    // '文章简介，摘要'
    @TableField("article_abstract")
    private String articleAbstract;

    // '首页主图url'
    private String mainImageUrl;

    // '作者id'
    private Integer memberId;

    // '标签 eg： 1,2,3 --> 博客,技术,java'
    private String label;

    // '阅读数'
    private Long readNum;

    // '文章内容'
    private String articleContent;

    // '首页是否展示 0 不展示 1展示'
    private Boolean showHome;

    // '修改时间'
    private LocalDateTime updateTime;

    // '创建时间'
    private LocalDateTime createTime;

    // '是否有效 1:是 0:否'
    private Boolean valid;

}
