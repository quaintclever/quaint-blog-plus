package com.quaint.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quaint.blog.dto.web.article.ArticleIdAndNameRespDto;
import com.quaint.blog.dto.web.article.ArticleInfoRespDto;
import com.quaint.blog.dto.web.article.GetArticleListRespDto;
import com.quaint.blog.po.ArticleInfoPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:06
 */
public interface ArticleInfoMapper extends BaseMapper<ArticleInfoPo> {

    List<GetArticleListRespDto> getHomeArticleList();

    List<GetArticleListRespDto> getArticleList();

    ArticleInfoRespDto getArticleById(Integer id);

    ArticleIdAndNameRespDto getArticleUpAndDown(@Param("id") Integer id, @Param("type") Integer type);

    List<ArticleIdAndNameRespDto> getSameArticleList(Integer id);

    List<GetArticleListRespDto> getSearchArticleByContent(String str);

    // 点击排行，默认前3
    @Select("SELECT id,article_title,article_abstract,main_image_url FROM article_info ORDER BY read_num desc limit 3")
    List<ArticleIdAndNameRespDto> getArticleByClickRank();

}
