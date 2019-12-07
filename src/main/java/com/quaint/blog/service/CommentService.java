package com.quaint.blog.service;

import com.quaint.blog.dto.web.article.CommentListDto;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-07 19:16
 */
public interface CommentService {

    List<CommentListDto> getCommentByArticleId(Integer articleId);

}
