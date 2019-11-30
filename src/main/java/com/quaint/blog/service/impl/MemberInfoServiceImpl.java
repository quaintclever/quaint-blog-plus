package com.quaint.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quaint.blog.dto.member.CheckLoginReqDto;
import com.quaint.blog.dto.member.CheckLoginRespDto;
import com.quaint.blog.mapper.MemberInfoMapper;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import com.quaint.blog.utils.MapperUtils;
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
    public CheckLoginRespDto checkLogin(CheckLoginReqDto dto) {
        MemberInfoPo memberPo = memberInfoMapper.checkLogin(dto);
        if (Objects.nonNull(memberPo)){
            System.out.println(MapperUtils.map(memberPo,CheckLoginRespDto.class).toString());
            return MapperUtils.map(memberPo,CheckLoginRespDto.class);
        }
        return null;
    }

}
