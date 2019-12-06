package com.quaint.blog.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-05 18:53
 */
@TableName("label_info")
@Data
public class LabelInfoPo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    // 标签名称
    private String labelName;

    // 标签类型 0 生活 1 情感 2 技术
    private Integer labelType;

    // '修改时间'
    private LocalDateTime updateTime;

    // '创建时间'
    private LocalDateTime createTime;

    // '是否有效 1:是 0:否'
    private Boolean valid;

}
