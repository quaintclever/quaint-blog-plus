package com.quaint.blog.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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

    @TableField("nick_name")
    private String nickName;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;


}
