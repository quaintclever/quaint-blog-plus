package com.quaint.blog.controller;

import com.quaint.blog.constant.MemberConstant;
import com.quaint.blog.dto.member.CheckLoginReqDto;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:19
 */
@RestController
public class MemberInfoController {

    @Autowired
    MemberInfoService memberInfoService;

    /**
     * 测试代码
     * @return
     */
    @RequestMapping("/memberList")
    public List<MemberInfoPo> getMemberInfoList(){
        return memberInfoService.getMemberList();
    }

    /**
     * 登录校验
     */
    @PostMapping(MemberConstant.CHECK_LOGIN)
    public boolean checkLogin(CheckLoginReqDto dto){
        return memberInfoService.checkLogin(dto);
    }

}
