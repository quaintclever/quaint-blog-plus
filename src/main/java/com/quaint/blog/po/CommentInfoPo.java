package com.quaint.blog.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-08 23:44
 */
@Data
@TableName("comment_info")
public class CommentInfoPo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer articleId;
    private Integer memberId;
    // 父评论id
    private Integer parentId;
    // 回复的用户id
    private Integer reId;
    private String commentContent;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean valid;

}
