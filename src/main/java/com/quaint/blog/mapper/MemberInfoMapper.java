package com.quaint.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quaint.blog.dto.member.CheckLoginReqDto;
import com.quaint.blog.po.MemberInfoPo;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/22 11:06
 */
public interface MemberInfoMapper extends BaseMapper<MemberInfoPo> {

    MemberInfoPo checkLogin(CheckLoginReqDto dto);

}
