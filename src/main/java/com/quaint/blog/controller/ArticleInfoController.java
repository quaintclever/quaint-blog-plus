package com.quaint.blog.controller;

import com.quaint.blog.constant.ArticleConstant;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;
import com.quaint.blog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:19
 */
@RestController
public class ArticleInfoController {

    @Autowired
    ArticleInfoService articleInfoService;

    @RequestMapping(ArticleConstant.WEB_HOME_ARTICLE_LIST)
    public List<GetArticleListRespDto> getHomeArticleList(){
        return articleInfoService.getHomeArticleList();
    }

    @RequestMapping(ArticleConstant.WEB_ARTICLE_LIST)
    public List<GetArticleListRespDto> getArticleList(){
        return articleInfoService.getArticleList();
    }

}
