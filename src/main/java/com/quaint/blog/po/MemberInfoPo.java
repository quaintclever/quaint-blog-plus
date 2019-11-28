package com.quaint.blog.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 10:55
 */
@TableName("member_info")
public class MemberInfoPo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("nack_name")
    private String nackName;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNackName() {
        return nackName;
    }

    public void setNackName(String nackName) {
        this.nackName = nackName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberInfoPo{" +
                "id=" + id +
                ", nackName='" + nackName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}