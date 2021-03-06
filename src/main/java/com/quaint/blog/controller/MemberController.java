package com.quaint.blog.controller;

import com.quaint.blog.annotation.CheckLogin;
import com.quaint.blog.constant.MemberConstant;
import com.quaint.blog.dto.web.member.CheckLoginReqDto;
import com.quaint.blog.dto.web.member.CheckLoginRespDto;
import com.quaint.blog.dto.web.member.MemberInfoRespDto;
import com.quaint.blog.dto.web.member.RegisterReqDto;
import com.quaint.blog.helper.LoginContext;
import com.quaint.blog.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:19
 */
@RestController
public class MemberController {

    @Autowired
    MemberInfoService memberInfoService;

    @PostMapping(MemberConstant.WEB_CHECK_LOGIN)
    public CheckLoginRespDto checkLogin(@RequestBody CheckLoginReqDto dto){
        return memberInfoService.checkLogin(dto);
    }

    @PostMapping(MemberConstant.WEB_REGISTER_IN)
    public CheckLoginRespDto registerIn(@RequestBody RegisterReqDto dto){
        return memberInfoService.registerIn(dto);
    }

    @PostMapping(MemberConstant.WEB_GET_MEMBER_INFO)
    @CheckLogin
    public MemberInfoRespDto getMemberInfo(){
        return memberInfoService.getMemberInfoById(LoginContext.getMemberId());
    }

}
