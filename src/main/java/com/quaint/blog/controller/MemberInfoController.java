package com.quaint.blog.controller;

import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/memberList")
    public List<MemberInfoPo> getMemberInfoList(){
        return memberInfoService.getMemberList();
    }

}
