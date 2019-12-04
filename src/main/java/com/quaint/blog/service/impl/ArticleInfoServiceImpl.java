package com.quaint.blog.service.impl;

import com.quaint.blog.dto.base.IdReqDto;
import com.quaint.blog.dto.web.article.ArticleInfoRespDto;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;
import com.quaint.blog.mapper.ArticleInfoMapper;
import com.quaint.blog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:15
 */
@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

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

    @Override
    public ArticleInfoRespDto getArticleById(IdReqDto idReqDto) {
        return articleInfoMapper.getArticleById(idReqDto.getId());
    }


}
