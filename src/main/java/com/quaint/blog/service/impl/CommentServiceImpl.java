package com.quaint.blog.service.impl;

import com.quaint.blog.dto.web.article.CommentListDto;
import com.quaint.blog.mapper.CommentInfoMapper;
import com.quaint.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-07 19:16
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentInfoMapper commentInfoMapper;

    /**
     * 查询评论列表
     * @param articleId
     * @return
     */
    public List<CommentListDto> getCommentByArticleId(Integer articleId){
        System.out.println(articleId);
        return commentInfoMapper.getCommentByArticleId(articleId);
    }



}
