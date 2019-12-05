package com.quaint.blog.dto.web.article;

import lombok.Data;

/**
 * @Description: 上一篇，下一篇展示使用
 * @author: qi cong
 * @Date: Created in 2019-12-04 13:51
 */
@Data
public class ArticleIdAndNameRespDto {

    private Integer id;
    private String articleTitle;

    // 点击排行文章使用  摘要
    private String articleAbstract;
    private String mainImageUrl;

}
