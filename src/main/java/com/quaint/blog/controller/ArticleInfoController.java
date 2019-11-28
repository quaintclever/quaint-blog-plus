package com.quaint.blog.controller;

import com.quaint.blog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:19
 */
@RestController
public class ArticleInfoController {

    @Autowired
    ArticleInfoService articleInfoService;

}
