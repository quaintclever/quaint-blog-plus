package com.quaint.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;
import com.quaint.blog.po.ArticleInfoPo;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:06
 */
public interface ArticleInfoMapper extends BaseMapper<ArticleInfoPo> {

    List<GetArticleListRespDto> getHomeArticleList();

    List<GetArticleListRespDto> getArticleList();

}
