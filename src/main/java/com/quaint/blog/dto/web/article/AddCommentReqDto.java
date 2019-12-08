package com.quaint.blog.dto.web.article;

import lombok.Data;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-08 23:41
 */
@Data
public class AddCommentReqDto {

    private Integer articleId;
    private Integer memberId;
    // 父评论id
    private Integer parentId;
    // 回复的用户id
    private Integer reId;
    private String commentContent;

}
