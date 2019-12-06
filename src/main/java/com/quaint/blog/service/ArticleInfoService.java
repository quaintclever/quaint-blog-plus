package com.quaint.blog.service;

import com.quaint.blog.dto.base.IdReqDto;
import com.quaint.blog.dto.web.article.ArticleIdAndNameRespDto;
import com.quaint.blog.dto.web.article.ArticleInfoRespDto;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:14
 */
public interface ArticleInfoService {

    /**
     *  获取 首页文章展示列表
     * @return
     */
    List<GetArticleListRespDto> getHomeArticleList();

    /**
     * 获取 文章展示列表 （后期分页处理）
     * @return
     */
    List<GetArticleListRespDto> getArticleList();

    /**
     * 通过文章id 获取文章信息
     * @param idReqDto
     * @return
     */
    ArticleInfoRespDto getArticleById(IdReqDto idReqDto);

    /**
     * 通过关键字，搜索文章
     * @param str
     * @return
     */
    List<GetArticleListRespDto> getArticleBySearch(String str);

    /**
     * 获取文章浏览排行
     * @return
     */
    List<ArticleIdAndNameRespDto> getArticleByClickRank();

    /**
     * 通过标签id搜索文章列表
     * @return
     */
    List<GetArticleListRespDto> getArticleByLabelId(Integer labelId);

}
