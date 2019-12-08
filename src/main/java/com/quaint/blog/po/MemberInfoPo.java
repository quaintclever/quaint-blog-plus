package com.quaint.blog.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 10:55
 */
@Data
@TableName("member_info")
public class MemberInfoPo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 用户昵称
    @TableField("nick_name")
    private String nickName;

    // 用户头像
    @TableField("head_img_url")
    private String headImgUrl;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    // '修改时间'
    private LocalDateTime updateTime;

    // '创建时间'
    private LocalDateTime createTime;

    // '是否有效 1:是 0:否'
    private Boolean valid;


}
