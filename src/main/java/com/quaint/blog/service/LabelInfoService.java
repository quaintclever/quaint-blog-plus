package com.quaint.blog.service;

import com.quaint.blog.dto.web.label.LabelRespDto;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-05 18:57
 */
public interface LabelInfoService {


    /**
     * 获取标签列表
     * @return
     */
    List<LabelRespDto> getLabelList();

}
