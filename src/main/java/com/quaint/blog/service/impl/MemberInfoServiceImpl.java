package com.quaint.blog.service.impl;

import com.quaint.blog.constant.MemberConstant;
import com.quaint.blog.dto.web.member.CheckLoginReqDto;
import com.quaint.blog.dto.web.member.CheckLoginRespDto;
import com.quaint.blog.dto.web.member.MemberInfoRespDto;
import com.quaint.blog.dto.web.member.RegisterReqDto;
import com.quaint.blog.mapper.MemberInfoMapper;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.MemberInfoService;
import com.quaint.blog.utils.JwtUtils;
import com.quaint.blog.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    MemberInfoMapper memberInfoMapper;

    // 通过用户信息生成token
    @Override
    public String getTokenByMemberInfo(MemberInfoPo memberInfoPo) {
        Map<String, String> memberMap = new HashMap<>();
        memberMap.put("username",memberInfoPo.getUsername());
        return JwtUtils.createToken(memberInfoPo.getId().toString(),memberMap);
    }

    // 通过token 获取用户id
    @Override
    public Integer getMemberIdByToken(String token) {
        Map<String, String> memberMap = JwtUtils.verifyToken(token);
        if (memberMap!=null){
            return Integer.parseInt(memberMap.get("iss"));
        }
        log.warn("impl -> token 无效");
        return null;
    }

    // 通过id 获取用户信息
    @Override
    public MemberInfoRespDto getMemberInfoById(Integer id) {
        MemberInfoPo memberPo = memberInfoMapper.selectById(id);
        if (Objects.nonNull(memberPo)){
            MemberInfoRespDto respDto = new MemberInfoRespDto();
            respDto.setNickName(memberPo.getNickName());
            respDto.setHeadImgUrl(memberPo.getHeadImgUrl());
            return respDto;
        }
        return null;
    }

    /**
     * release/1.1【 用户注册功能 】
     * Be used for [Find in Path...]
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
        // 返回accessToken
        CheckLoginRespDto respDto = new CheckLoginRespDto();
        respDto.setAccessToken(getTokenByMemberInfo(register));
        return respDto;
    }

    /**
     * release/1.1【 用户登录逻辑 】
     * Be used for [Find in Path...]
     */
    @Override
    public CheckLoginRespDto checkLogin(CheckLoginReqDto dto) {
        MemberInfoPo memberPo = memberInfoMapper.checkLogin(dto);
        if (Objects.nonNull(memberPo)){
            log.info("用户[{}]登录成功,返回token",memberPo.getId());
            CheckLoginRespDto respDto = new CheckLoginRespDto();
            respDto.setAccessToken(getTokenByMemberInfo(memberPo));
            return respDto;
        }
        return null;
    }

}
