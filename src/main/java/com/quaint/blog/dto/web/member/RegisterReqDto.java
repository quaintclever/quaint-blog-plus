package com.quaint.blog.dto.web.member;

import lombok.Data;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-08 23:11
 */
@Data
public class RegisterReqDto {

    private String username;
    private String nickName;
    private String pwd;
    private String rePwd;

}
