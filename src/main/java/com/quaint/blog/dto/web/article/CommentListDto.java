package com.quaint.blog.dto.web.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-07 18:43
 */
@Data
public class CommentListDto {

    // 评论列表id
    private Integer id;
    // 评论的对应文章id
    private Integer articleId;
    // 评论者的id
    private Integer comMemberId;
    // 评论者的昵称
    private String comMemberName;
    // 评论的内容
    private String comContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
    // 回复的内容
    List<ReCommentList> reComments;

    @Data
    private static class ReCommentList{

        // 回复者id
        private Integer reMemberId;
        // 回复者昵称
        private String reMemberName;
        // 回复内容
        private String reContent;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private LocalDateTime reCreateTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private LocalDateTime reUpdateTime;
        // @的用户id
        private Integer aitMemberId;
        // @的用户昵称
        private String aitMemberName;

    }

}
