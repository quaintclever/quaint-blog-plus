package com.quaint.blog.service;

import com.quaint.blog.dto.web.article.GetArticleListRespDto;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:14
 */
public interface ArticleInfoService {

    /**
     *  获取 首页文章展示列表 （后期处理分页）
     * @return
     */
    List<GetArticleListRespDto> getHomeArticleList();

    /**
     * 获取 文章展示列表 （后期分页处理）
     * @return
     */
    List<GetArticleListRespDto> getArticleList();

}
