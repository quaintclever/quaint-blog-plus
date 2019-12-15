package com.quaint.blog.controller;

import com.quaint.blog.constant.LabelConstant;
import com.quaint.blog.dto.web.label.LabelRespDto;
import com.quaint.blog.po.MemberInfoPo;
import com.quaint.blog.service.LabelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-05 19:02
 */
@RestController
public class LabelController {

    @Autowired
    LabelInfoService labelInfoService;

    /**
     * 测试接口是否可调用
     * @return
     */
    @RequestMapping("/quaintTest")
    public List<LabelRespDto> quaintTest(){
        return labelInfoService.getLabelList();
    }

    @PostMapping(LabelConstant.WEB_LABEL_LIST)
    public List<LabelRespDto> getLabelList(){
        return labelInfoService.getLabelList();
    }

}
