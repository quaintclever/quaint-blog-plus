package com.quaint.blog.dto.web.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quaint.blog.dto.web.label.LabelRespDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description: 首页展示的文章列表 dto
 * @author: qi cong
 * @Date: Created in 2019-12-03 17:29
 */
@Data
public class GetArticleListRespDto {

    private Integer id;

    private Integer memberId;

    // '文章标题'
    private String articleTitle;

    // '文章简介，摘要'
    private String articleAbstract;

    // '首页主图url'
    private String mainImageUrl;

    // '标签 eg： 1,2,3 --> 博客,技术,java'
    private List<LabelRespDto> labels;

    // '阅读数'
    private Long readNum;

    // '修改时间'
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;



}
