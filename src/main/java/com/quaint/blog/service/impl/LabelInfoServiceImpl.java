package com.quaint.blog.service.impl;

import com.quaint.blog.dto.web.label.LabelRespDto;
import com.quaint.blog.mapper.LabelInfoMapper;
import com.quaint.blog.po.LabelInfoPo;
import com.quaint.blog.service.LabelInfoService;
import com.quaint.blog.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-05 18:58
 */
@Service
public class LabelInfoServiceImpl implements LabelInfoService {

    @Autowired
    LabelInfoMapper labelInfoMapper;

    @Override
    public List<LabelRespDto> getLabelList() {
        List<LabelInfoPo> list = labelInfoMapper.selectList(null);
        // 吧po 转换成dto
        return list.stream().map(e -> MapperUtils.map(e,LabelRespDto.class)).collect(Collectors.toList());
    }
}
