package com.quaint.blog.service.impl;

import com.quaint.blog.dto.web.article.AddCommentReqDto;
import com.quaint.blog.dto.web.article.CommentListDto;
import com.quaint.blog.helper.MUOContext;
import com.quaint.blog.mapper.CommentInfoMapper;
import com.quaint.blog.po.CommentInfoPo;
import com.quaint.blog.service.CommentService;
import com.quaint.blog.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
     * blog-1.0.1【 用户评论或留言 】
     * Be used for [Find in Path...]
     * Keymap --> (shift+control+F)
     */
    @Override
    public Boolean articleAddComment(AddCommentReqDto addDto) {

        System.out.println(MUOContext.getMemberId());

        CommentInfoPo addCom = new CommentInfoPo();
        addCom.setArticleId(addDto.getArticleId());
        addCom.setCommentContent(addDto.getCommentContent());
        addCom.setMemberId(addDto.getMemberId());
        addCom.setParentId(addDto.getParentId());
        addCom.setReId(addDto.getReId());
        return commentInfoMapper.insert(addCom)>0;
    }

    /**
     * 查询评论列表
     * @param articleId
     * @return
     */
    public List<CommentListDto> getCommentByArticleId(Integer articleId){

        // 如果没有评论，直接返回空
        Integer comCount = commentInfoMapper.getCommentCountByArticleId(articleId);
        if(Objects.isNull(comCount) || comCount.equals(0)) return null;

        //  有评论，返回数据
        List<CommentListDto> commentList = commentInfoMapper.getCommentByArticleId(articleId);
        commentList.get(0).setCommentCount(comCount);
        return commentList;
    }



}
