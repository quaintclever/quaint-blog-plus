package com.quaint.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quaint.blog.dto.member.CheckLoginReqDto;
import com.quaint.blog.mapper.MemberInfoMapper;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:15
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    MemberInfoMapper memberInfoMapper;

    @Override
    public List<MemberInfoPo> getMemberList() {
        QueryWrapper<MemberInfoPo> queryWrapper = new QueryWrapper<>();
        return memberInfoMapper.selectList(queryWrapper);
    }

    @Override
    public boolean checkLogin(CheckLoginReqDto dto) {
        if (Objects.nonNull(memberInfoMapper.checkLogin(dto)))
            return true;
        return false;
    }

}
