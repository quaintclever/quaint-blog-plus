package com.quaint.blog.service.impl;

import com.quaint.blog.dto.base.IdReqDto;
import com.quaint.blog.dto.web.article.ArticleIdAndNameRespDto;
import com.quaint.blog.dto.web.article.ArticleInfoRespDto;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;
import com.quaint.blog.mapper.ArticleInfoMapper;
import com.quaint.blog.po.ArticleInfoPo;
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
        return respDto;
    }


}
