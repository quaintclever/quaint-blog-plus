package com.quaint.blog.controller;

import com.quaint.blog.constant.MemberConstant;
import com.quaint.blog.dto.admin.member.CheckLoginReqDto;
import com.quaint.blog.dto.admin.member.CheckLoginRespDto;
import com.quaint.blog.dto.admin.member.RegisterReqDto;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:19
 */
@RestController
public class MemberController {

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
    @PostMapping(MemberConstant.WEB_CHECK_LOGIN)
    public CheckLoginRespDto checkLogin(@RequestBody CheckLoginReqDto dto){
        return memberInfoService.checkLogin(dto);
    }

    /**
     * 注册账号
     * @param dto
     * @return
     */
    @PostMapping(MemberConstant.WEB_REGISTER_IN)
    public CheckLoginRespDto registerIn(@RequestBody RegisterReqDto dto){
        return memberInfoService.registerIn(dto);
    }

}
