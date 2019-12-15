package com.quaint.blog.dto.web.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quaint.blog.dto.web.label.LabelRespDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-28 10:06
 */
@Data
public class ArticleInfoRespDto {

    private Integer id;

    // '文章标题'
    private String articleTitle;

    // '文章简介，摘要'
    private String articleAbstract;

    // '阅读数'
    private Long readNum;

    // '文章内容'
    private String articleContent;

    // '修改时间'
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    // --- 关联字段 ---
    // '作者id'
    private Integer memberId;

    // 作者名称
    private String nickName;

    // 标签名称
    private List<LabelRespDto> labels;

    // --- 扩展字段 ---
    // 上一篇
    private ArticleIdAndNameRespDto up;
    // 下一篇
    private ArticleIdAndNameRespDto down;
    // 相关文章
    private List<ArticleIdAndNameRespDto> sameArticles;


}
