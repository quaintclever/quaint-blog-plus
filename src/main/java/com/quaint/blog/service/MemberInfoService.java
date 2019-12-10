package com.quaint.blog.service;

import com.quaint.blog.dto.web.member.CheckLoginReqDto;
import com.quaint.blog.dto.web.member.CheckLoginRespDto;
import com.quaint.blog.dto.web.member.RegisterReqDto;
import com.quaint.blog.po.MemberInfoPo;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:14
 */
public interface MemberInfoService {

    // 登录校验接口
    CheckLoginRespDto checkLogin(CheckLoginReqDto dto);

    // 用户注册接口
    CheckLoginRespDto registerIn(RegisterReqDto dto);

}
