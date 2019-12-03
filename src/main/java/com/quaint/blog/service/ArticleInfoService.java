package com.quaint.blog.service;

import com.quaint.blog.po.ArticleInfoPo;

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
    List<ArticleInfoPo> getHomeArticleList();

}
