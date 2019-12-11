package com.quaint.blog.service.impl;

import com.quaint.blog.constant.MemberConstant;
import com.quaint.blog.dto.web.member.CheckLoginReqDto;
import com.quaint.blog.dto.web.member.CheckLoginRespDto;
import com.quaint.blog.dto.web.member.RegisterReqDto;
import com.quaint.blog.mapper.MemberInfoMapper;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import com.quaint.blog.utils.JwtUtils;
import com.quaint.blog.utils.MapperUtils;
import com.quaint.blog.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:15
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    private static final Logger logger = LoggerFactory.getLogger(MemberInfoServiceImpl.class);

    @Autowired
    MemberInfoMapper memberInfoMapper;

    @Override
    public String getTokenByMemberInfo(MemberInfoPo memberInfoPo) {
        Map<String, String> memberMap = new HashMap<>();
        memberMap.put("username",memberInfoPo.getUsername());
        return JwtUtils.createToken(memberInfoPo.getId().toString(),memberMap);
    }

    @Override
    public Integer getMemberIdByToken(String token) {
        Map<String, String> memberMap = JwtUtils.verifyToken(token);
        if (memberMap!=null){
            return Integer.parseInt(memberMap.get("iss"));
        }
        logger.warn("impl -> token 无效");
        return null;
    }

    /**
     * blog-1.0.1【 用户注册功能，校验尚未完善 】
     * Be used for [Find in Path...]
     * Keymap --> (shift+control+F)
     */
    @Override
    public CheckLoginRespDto registerIn(RegisterReqDto dto) {
        // 插入用户信息
        MemberInfoPo register = new MemberInfoPo();
        register.setNickName(dto.getNickName());
        register.setUsername(dto.getUsername());
        register.setPassword(dto.getPwd());
        register.setHeadImgUrl(
                String.format(MemberConstant.DEFAULT_MEMBER_HEAD_IMG, RandomUtils.getInteger(1,300)));
        memberInfoMapper.insert(register);
        // 返回用户信息
        CheckLoginRespDto respDto = new CheckLoginRespDto();
        respDto.setId(register.getId());
        respDto.setNickName(register.getNickName());
        respDto.setHeadImgUrl(register.getHeadImgUrl());
        return respDto;
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
