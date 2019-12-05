package com.quaint.blog.service.impl;

import com.quaint.blog.dto.base.IdReqDto;
import com.quaint.blog.dto.web.article.ArticleIdAndNameRespDto;
import com.quaint.blog.dto.web.article.ArticleInfoRespDto;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;
import com.quaint.blog.mapper.ArticleInfoMapper;
import com.quaint.blog.po.ArticleInfoPo;
import com.quaint.blog.service.ArticleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:15
 */
@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleInfoServiceImpl.class);

    @Autowired
    ArticleInfoMapper articleInfoMapper;


    @Override
    public List<GetArticleListRespDto> getHomeArticleList(){
        return articleInfoMapper.getHomeArticleList();
    }

    @Override
    public List<GetArticleListRespDto> getArticleList() {
        return articleInfoMapper.getArticleList();
    }

    /**
     * blog-1.0.1【 通过id查询文章 】
     * Be used for [Find in Path...]
     * Keymap --> (shift+control+F)
     */
    @Override
    public ArticleInfoRespDto getArticleById(IdReqDto idReqDto) {

        ArticleInfoRespDto respDto = articleInfoMapper.getArticleById(idReqDto.getId());
        respDto.setReadNum(respDto.getReadNum()+1);

        // 增加阅读数
        ArticleInfoPo addReadNum = new ArticleInfoPo();
        addReadNum.setId(idReqDto.getId());
        addReadNum.setReadNum(respDto.getReadNum());
        articleInfoMapper.updateById(addReadNum);

        // 获取文章 0 上一篇， 1 下一篇
        ArticleIdAndNameRespDto up = articleInfoMapper.getArticleUpAndDown(idReqDto.getId(),0);
        ArticleIdAndNameRespDto down = articleInfoMapper.getArticleUpAndDown(idReqDto.getId(),1);
        respDto.setUp(up);
        respDto.setDown(down);

        // 获取相关文章list
        respDto.setSameArticles(articleInfoMapper.getSameArticleList(idReqDto.getId()));
        return respDto;
    }

    /**
     * blog-1.0.1【 通过关键字搜索文章 】
     * Be used for [Find in Path...]
     * Keymap --> (shift+control+F)
     */
    @Override
    public List<GetArticleListRespDto> getArticleBySearch(String str) {

        logger.info("通过关键字搜索入参：str:[{}]",str);
        if (StringUtils.isEmpty(str)){
            logger.info("搜索内容不能为空,直接返回所有的文章列表");
            return getArticleList();
        }
        List<GetArticleListRespDto> list = articleInfoMapper.getSearchArticleByContent(str);
        return list;
    }


}
