package com.quaint.blog.controller;

import com.quaint.blog.constant.CommentConstant;
import com.quaint.blog.dto.base.IdReqDto;
import com.quaint.blog.dto.web.article.AddCommentReqDto;
import com.quaint.blog.dto.web.article.CommentListDto;
import com.quaint.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-07 19:15
 */
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(CommentConstant.WEB_ARTICLE_COMMENT_LIST)
    public List<CommentListDto> getCommentByArticleId(@RequestBody IdReqDto idReqDto){
        return commentService.getCommentByArticleId(idReqDto.getId());
    }

    @PostMapping(CommentConstant.WEB_ARTICLE_ADD_COMMENT)
    public Boolean articleAddComment(@RequestBody AddCommentReqDto addDto){
        return commentService.articleAddComment(addDto);
    }



}
