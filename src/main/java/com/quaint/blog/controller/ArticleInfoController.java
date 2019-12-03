package com.quaint.blog.controller;

import com.quaint.blog.po.ArticleInfoPo;
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
@RequestMapping("/article")
public class ArticleInfoController {

    @Autowired
    ArticleInfoService articleInfoService;

    @RequestMapping("/home")
    public List<ArticleInfoPo> getHomeArticleList(){
        return articleInfoService.getHomeArticleList();
    }

}
