package com.quaint.blog.mapper;

import com.quaint.blog.dto.web.article.CommentListDto;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-07 18:38
 */
public interface CommentInfoMapper {

    List<CommentListDto> getCommentByArticleId(Integer articleId);

}
