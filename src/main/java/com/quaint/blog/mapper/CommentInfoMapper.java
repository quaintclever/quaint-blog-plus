package com.quaint.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quaint.blog.dto.web.article.CommentListDto;
import com.quaint.blog.po.CommentInfoPo;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-07 18:38
 */
public interface CommentInfoMapper extends BaseMapper<CommentInfoPo> {

    List<CommentListDto> getCommentByArticleId(Integer articleId);

    Integer getCommentCountByArticleId(Integer articleId);

}
