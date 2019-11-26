package com.quaint.blog.service;

import com.quaint.blog.dto.member.CheckLoginReqDto;
import com.quaint.blog.po.MemberInfoPo;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:14
 */
public interface MemberInfoService {

    // 测试接口
    List<MemberInfoPo> getMemberList();

    // 登录校验接口
    boolean checkLogin(CheckLoginReqDto dto);

}
